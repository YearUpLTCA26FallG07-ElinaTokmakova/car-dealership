package com.pluralsight.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);

    public static String promptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int promptForInt(String prompt) {
        String input = "";
        boolean isValid = false;

        while(true) {
            try{
                System.out.print(prompt);
                input = scanner.nextLine().trim();

                // if input is not empty convert to integer
                if (!input.isEmpty()) {
                    return Integer.parseInt(input);

                    // if empty leave blank
                } else {
                    return 0;
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid whole number.");
                scanner.nextLine(); // Clear the bad input from the scanner buffer
            } catch (Exception e) {
                System.out.println("\nSomething went wrong. Please try again.");
            }
        }
    }

    public static double promptForDouble(String prompt) {
        double result = 0.0;
        boolean isValid = false;

        do {
            try {
                System.out.print(prompt);
                result = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline
                isValid = true;     // Input was successful, exit loop
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the bad input from the scanner buffer
            }
        } while (!isValid);

        return result;
    }

    public static BigDecimal promptForBigDecimal(String prompt) {
        BigDecimal result = BigDecimal.valueOf(0.00);
        boolean isValid = false;

        do {
            try {
                System.out.print(prompt);
                result = scanner.nextBigDecimal();
                scanner.nextLine(); // Consume the newline
                // 2 decimals format
                result = result.setScale(2, RoundingMode.HALF_UP);
                isValid = true;     // Input was successful, exit loop
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the newline from the scanner buffer
            }
        } while (!isValid);

        return result;
    }
}
