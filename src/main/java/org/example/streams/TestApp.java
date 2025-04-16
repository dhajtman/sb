package org.example.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestApp {
    public static void main(String[] args) {
        List<String> newValues = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        System.out.println("All values:");
        newValues.forEach(a -> {
            System.out.print(" " + a);
        });

        System.out.println("\n\nFiltered values:");
        newValues.stream().filter(a -> a.startsWith("t")).forEach(a -> {
            System.out.print(" " + a);
        });

        System.out.println("\n\nMapped values:");
        newValues.stream().filter(a -> a.startsWith("t")).map(String::toUpperCase).forEach(a -> {
            System.out.print(" " + a);
        });

        System.out.println("\n\nMapped and filtered values:");
        newValues.stream().filter(a -> a.startsWith("t")).map(a -> a.substring(0, 1)).forEach(a -> {
            System.out.print(" " + a);
        });

        System.out.println("\n\nMapped, filtered, and distinct values:");
        newValues.stream().filter(a -> a.startsWith("t")).map(a -> a.substring(0, 1)).distinct().forEach(a -> {
            System.out.print(" " + a);
        });

        System.out.println("\n\nMapped, filtered, distinct, and sorted values:");
        newValues.stream().sorted(Comparator.comparing(String::length)).forEach(a -> {
            System.out.print(" " + a);
        });

        System.out.println("\n\nMapped, filtered, distinct, sorted, and forEach values:");
        newValues.stream().sorted(Comparator.comparing(String::valueOf)).forEach(a -> {
            System.out.print(" " + a);
        });

        System.out.println("\n\nMapped, filtered, distinct, sorted, forEach, and reversed values:");
        newValues.stream().sorted(Comparator.comparing(String::valueOf).reversed()).forEach(a -> {
            System.out.print(" " + a);
        });

        System.out.println("\n\nMapped, filtered, distinct, sorted, forEach, reversed, and peek values:");
        newValues.stream().sorted(Comparator.comparing(String::valueOf)).peek(a -> {
            System.out.print(" debug: " + a);
        }).toList();

        System.out.println("\n\nLimit values:");
        newValues.stream().limit(3).forEach(a -> {
            System.out.print(" " + a);
        });

        System.out.println("\n\nSkip values:");
        newValues.stream().skip(3).forEach(a -> {
            System.out.print(" " + a);
        });

        System.out.println("\n\nTakeWhile values:");
        newValues.stream().takeWhile(a -> !a.startsWith("t")).forEach(a -> {
            System.out.print(" " + a);
        });

        System.out.println("\n\nDropWhile values:");
        newValues.stream().dropWhile(a -> !a.startsWith("t")).forEach(a -> {
            System.out.print(" " + a);
        });

        System.out.println("\n\nArray values:");
        String[] array = newValues.stream().toArray(String[]::new);
        System.out.println("Array: " + Arrays.asList(array));

        System.out.println("\n\nMin value:");
        newValues.stream().min(Comparator.comparing(String::length)).ifPresent(a -> {
            System.out.print(" " + a);
        });

        System.out.println("\n\nMax value:");
        newValues.stream().max(Comparator.comparing(String::length)).ifPresent(a -> {
            System.out.print(" " + a);
        });

        System.out.println("\n\nallMatch values:");
        boolean bool = newValues.stream().allMatch(a -> a.startsWith("t"));
        System.out.println("All match: " + bool);

        System.out.println("\n\nanyMatch values:");
        bool = newValues.stream().anyMatch(a -> a.startsWith("t"));
        System.out.println("Any match: " + bool);

        System.out.println("\n\nnoneMatch values:");
        bool = newValues.stream().noneMatch(a -> a.length() > 10);
        System.out.println("None match: " + bool);

        System.out.println("\n\ncount values:");
        long count = newValues.stream().count();
        System.out.println("Count: " + count);

        System.out.println("\n\nreduce values:");
        String reduced1 = newValues.stream().reduce("", String::concat);
        System.out.println("Reduced1: " + reduced1);

        System.out.println("\n\nreduce values:");
        String reduced2 = newValues.stream().reduce("", (a, b) -> a.length() > b.length() ? a : b);
        System.out.println("Reduced2: " + reduced2);

        System.out.println("\n\nreduce values:");
        String reduced3 = newValues.stream().reduce("text", (a, b) -> a + " : " +  b);
        System.out.println("Reduced3: " + reduced3);
    }
}
