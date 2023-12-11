package org.amch;

import java.util.*;

public class SequencedCollectionTest {
	public static void main(String[] args) {
		testCollections();
		testSets();
		testMaps();
	}

	public static void testCollections() {
		System.out.println("* List");

		List<String> list = new ArrayList<>();
		SequencedCollection<String> sequenced = new ArrayList<>();

		list.add("1");
		sequenced.add("1");
		System.out.println("=============== INIT =============");
		print(list, sequenced);


		list.set(0, "First");
		sequenced.addFirst("First");

		System.out.println("=============== FIRST =============");
		print(list, sequenced);

		// add last (tail)
		list.add("last");
		sequenced.addLast("last");

		System.out.println("=============== LAST =============");
		print(list, sequenced);

		// get first
		list.get(0);
		sequenced.getFirst();

		// get last
		list.get(list.size() - 1);
		sequenced.getLast();

		// remove first
		list.remove(0);
		sequenced.removeFirst();
		System.out.println("=============== REMOVE FIRST =============");
		print(list, sequenced);

		// remove last
		list.remove(list.size() - 1);
		sequenced.removeLast();
		System.out.println("=============== REMOVE LAST =============");
		print(list, sequenced);

		// descending iterator
		ListIterator<String> reversed = list.listIterator(list.size());
		while (reversed.hasPrevious()) {
			reversed.previous();
		}
		Iterator<String> reversedSequence = sequenced.reversed().iterator();
	}

	public static void testSets() {
		System.out.println("* Set");

		Set<String> set = new LinkedHashSet<>();
		SequencedSet<String> sequenced = new LinkedHashSet<>();

		set.add("1");
		sequenced.add("1");
		System.out.println("=============== INIT =============");
		print(set, sequenced);


		set.iterator().next();
		sequenced.getFirst();

		// get last
		Iterator<String> iterator = set.iterator();
		String last;
		while (iterator.hasNext())
			last = iterator.next();
		last = sequenced.getLast();

		// descending iterator
		Iterator<String> descendingIterator = new TreeSet<>(set).descendingSet().iterator();
		descendingIterator = sequenced.reversed().iterator();
	}

	public static void testMaps() {
		System.out.println("* Map");
		Map<String, String> map = new LinkedHashMap<>();
		SequencedMap<String, String> sequenced = new LinkedHashMap<>();

		map.put("1", "v1");
		sequenced.put("1", "v1");
		System.out.println("============= INIT =============");
		print(map, sequenced);

		// put first
		map.put("first", "v2");
		sequenced.putFirst("first", "v2");
		System.out.println("============= FIRST =============");
		print(map, sequenced);

		// get first
		var entry = map.entrySet().iterator().next();
		entry = sequenced.firstEntry();

		// put last
		map.put("last", "v2");
		sequenced.putLast("last", "v2");
		System.out.println("============= LAST =============");
		print(map, sequenced);

		// get last
		var iterator = map.entrySet().iterator();
		while (iterator.hasNext())
			entry = iterator.next();
		entry = sequenced.lastEntry();

		// reverse
		var reversedIterator = sequenced.reversed().entrySet().iterator();
	}

	public static <T> void  print(Collection<T> collection, SequencedCollection<T> newCollection) {
		System.out.printf("Collection: %s%n", collection);
		System.out.printf("Sequenced: %s%n", newCollection);
	}

	public static <K, V> void print(Map<K, V> collection, SequencedMap<K, V> newCollection) {
		System.out.printf("Map: %s%n", collection);
		System.out.printf("SequencedMap: %s%n", newCollection);
	}
}