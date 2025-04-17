package org.example.exceptions;

public class CheckedExceptionSample {
    public static void main(String[] args) {
        try {
            // Simulate a checked exception
            throw new Exception("This is a checked exception");
        } catch (Exception e) {
            System.out.println("Caught a checked exception: " + e.getMessage());
        }

        // Continue with the program
        System.out.println("Program continues after handling the exception.");
    }
}
