package com.manu;

import java.util.Scanner;

public class TemperatureConverter {

    public static double toCelsius(double value, char unit) {
        switch (unit) {
            case 'C': return value;
            case 'F': return (value - 32) * 5 / 9;
            case 'K': return value - 273.15;
            default: throw new IllegalArgumentException("Invalid unit");
        }
    }

    public static void displayResults(double value, char unit) {
        double celsius = toCelsius(value, unit);
        double fahrenheit = (celsius * 9 / 5) + 32;
        double kelvin = celsius + 273.15;

        System.out.println("\nConverted Values:");
        System.out.printf("Celsius: %.2f °C\n", celsius);
        System.out.printf("Fahrenheit: %.2f °F\n", fahrenheit);
        System.out.printf("Kelvin: %.2f K\n", kelvin);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("===== Temperature Conversion Program =====");

        while (running) {

            try {
                System.out.print("\nEnter temperature value: ");
                double value = scanner.nextDouble();

                System.out.print("Enter unit (C/F/K): ");
                char unit = scanner.next().toUpperCase().charAt(0);

                if (unit != 'C' && unit != 'F' && unit != 'K') {
                    System.out.println("Invalid unit! Please enter C, F, or K.");
                    continue;
                }

                displayResults(value, unit);

            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a numeric value.");
                scanner.nextLine(); // clear buffer
            }

            System.out.print("\nDo you want to convert again? (Y/N): ");
            char choice = scanner.next().toUpperCase().charAt(0);

            if (choice != 'Y') {
                running = false;
            }
        }

        System.out.println("Thank you for using the Temperature Converter!");
        scanner.close();
    }
}