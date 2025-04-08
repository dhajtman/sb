package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the number of exercises: ");
        int numberOfExercises = 0;
        try {
            numberOfExercises = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println("Error reading input: " + e);
            System.exit(1);
        }

        System.out.println("Number of exercises: " + numberOfExercises);

        Random random = new Random();
        int validExercises = 0;
        int correctAnswers = 0;
        int failedAnswers = 0;
        int timeouts = 0;

        while (validExercises < numberOfExercises) {
            int num1 = random.nextInt(101);
            char operation = random.nextBoolean() ? '+' : '-';
            int num2 = operation == '+' ? random.nextInt(101 - num1) : random.nextInt(num1 + 1);
            int correctResult = operation == '+' ? num1 + num2 : num1 - num2;

            System.out.println(num1 + " " + operation + " " + num2 + " = ?");

            ExecutorService executor = Executors.newSingleThreadExecutor();
            Future<String> future = executor.submit(() -> {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                // wait until we have data to complete a readLine()
                while (!br.ready()) {
                    Thread.sleep(200);
                }
                return br.readLine();
            });

            try {
                int userResult = Integer.parseInt(future.get(6, TimeUnit.SECONDS));
                if (userResult == correctResult) {
                    correctAnswers++;
                    System.out.println("Correct!");
                } else {
                    failedAnswers++;
                    System.out.println("Incorrect. The correct result is " + correctResult);
                }
            } catch (TimeoutException e) {
                System.out.println("Time's up! The correct result is " + correctResult);
                future.cancel(true);
                timeouts++;
            } catch (Exception e) {
                System.out.println("An error occurred: " + e);
            } finally {
                executor.shutdown();
            }
            validExercises++;
        }

        System.out.println("You answered " + correctAnswers + " correctly, "  + failedAnswers + " incorrectly and had " + timeouts + " timeouts out of " + numberOfExercises + " exercises.");
        System.exit(0); // Exit the main method
    }
}