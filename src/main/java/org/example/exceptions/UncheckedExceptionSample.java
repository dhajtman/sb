package org.example.exceptions;

public class UncheckedExceptionSample {
    public static void main(String[] args) {
        try {
            // Simulate an unchecked exception
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught an unchecked exception: " + e.getMessage());
        }

        // Continue with the program
        System.out.println("Program continues after handling the exception.");
    }
}
