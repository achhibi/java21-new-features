package org.amch;

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
