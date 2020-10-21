package com.java.myrotiuk;

import java.text.NumberFormat;
import java.util.Locale;

public class MyMain {
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory());

        var item = "Shirt";
        var price = 14.99;
        var itemString = String.format("Clothing item: %s, with price %.2f", item, price);
        System.out.println(itemString);
        //------
        var doubleValue = 10_000_000.53;
        var local = Locale.getDefault();//new Locale("de", "DE");
        var localeFormatter = NumberFormat.getNumberInstance(local);
        System.out.println("Number:" + localeFormatter.format(doubleValue));

        var currencyFormatter = NumberFormat.getCurrencyInstance();
        System.out.println(currencyFormatter.format(doubleValue));
    }
}
