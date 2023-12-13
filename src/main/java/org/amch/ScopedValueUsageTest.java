package org.amch;

public class ScopedValueUsageTest {
	final static ScopedValue<String> SCOPE = ScopedValue.newInstance();

	public static void main(String[] args) {
		System.out.println("main start");

		ScopedValue.where(SCOPE, "message from main")
			.run(() -> {
				var worker = new Worker();
				worker.execute();
			});
		System.out.println("main ending");
	}
}

class Worker {
	final static ScopedValue<String> WORKER_SCOPE = ScopedValue.newInstance();

	public void execute() {
		System.out.println(STR."shared value from main: \{ScopedValueUsageTest.SCOPE.get()}");

		// === Nested Scope ===
		ScopedValue.where(WORKER_SCOPE, "message from worker")
			.run(() -> {
				var messageFromMain = ScopedValueUsageTest.SCOPE.get();
				var messageFromWorker = WORKER_SCOPE.get();
				System.out.println(STR."shared value to inner scope from main: \{messageFromMain}");
				System.out.println(STR."shared value to inner scope from worker: \{messageFromWorker}");
			});


		ScopedValue.where(ScopedValueUsageTest.SCOPE, "message from worker over main")
			.run(() -> {
				var remindedMessage = ScopedValueUsageTest.SCOPE.get();
				System.out.println(STR."shared value from shadowed scope: \{remindedMessage}");
			});

		System.out.println(STR."shared value from main after all scopes: \{ScopedValueUsageTest.SCOPE.get()}");
	}
}