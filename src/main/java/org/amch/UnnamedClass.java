/***
 *  java --enable-preview --source 21 UnnamedClass.java
 */
static String staticField = "I'm a static field";
String istanceField = "I'm an instance field";
private String privateInstanceField = "I'm a private instance field";

void main() {
    System.out.printf("%s%n", staticField);
    System.out.printf("%s%n", istanceField);
    System.out.printf("%s%n", privateInstanceField);
}
static void instanceMethod() {
    System.out.println("can have any instance method");
}
static void staticMethod() {
    System.out.println("can have static method");
}