# Testing Java 21 New Features

This project contains examples of code to test the new features of Java 21.

## Features tested

* InstanceMainMethodLauncher
* RecordPattern
* SequencedCollection
* StringTemplate
* UnnamedClass
* ScopedValueUsageTest

## Examples

Each feature is represented by a java file containing one or more examples of code.

### UnnamedClass

 ```

/**
 **  java --enable-preview --source 21 UnnamedClass.java
 **/
static String staticField = "I'm static field";
String istanceField = "I'm instance field";
private String privateInstanceField = "I'm private instance field";

void main() {
    System.out.printf("%s%n", staticField);
    System.out.printf("%s%n", istanceField);
    System.out.printf("%s%n", privateInstanceField);
}

```

### StringTemplate

```
public class StringTemplateSample {
public static void main(String[] args) {
var productName = "IPhone 15";
var productPrice = 1129.99;
var productAvailable = true;

        String productInfo = STR."""
        Product: \{productName} Price: \{productPrice} Availability: \{productAvailable ? "In Stock" : "Out of Stock"}
        """;

        System.out.println(productInfo);

    }
}
```