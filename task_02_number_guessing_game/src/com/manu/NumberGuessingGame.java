package com.manu;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private int randomNumber;
    private int attempts;
    private int range;

    public NumberGuessingGame(int range) {
        this.range = range;
        this.attempts = 0;
        Random random = new Random();
        this.randomNumber = random.nextInt(range) + 1;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        int guess = -1;

        System.out.println("\n🎯 Guess the number between 1 and " + range);

        while (guess != randomNumber) {

            System.out.print("Enter your guess: ");

            if (!scanner.hasNextInt()) {
                System.out.println("⚠ Please enter a valid number!");
                scanner.next();
                continue;
            }

            guess = scanner.nextInt();
            attempts++;

            int difference = Math.abs(guess - randomNumber);

            if (difference == 0) {
                System.out.println("\n🎉 Correct! You guessed it in " + attempts + " attempts.");
                giveScore();
            }
            else if (difference <= 5) {
                if (guess > randomNumber)
                    System.out.println("🔥 Very close! Slightly high.");
                else
                    System.out.println("🔥 Very close! Slightly low.");
            }
            else if (difference <= 15) {
                if (guess > randomNumber)
                    System.out.println("🙂 Close! But high.");
                else
                    System.out.println("🙂 Close! But low.");
            }
            else {
                if (guess > randomNumber)
                    System.out.println("📉 Too high!");
                else
                    System.out.println("📈 Too low!");
            }
        }
    }

    private void giveScore() {
        if (attempts <= 3)
            System.out.println("🏆 Excellent performance!");
        else if (attempts <= 7)
            System.out.println("👏 Good job!");
        else
            System.out.println("🙂 You got it, but try to improve next time!");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char playAgain;

        System.out.println("🎮 Welcome to the Advanced Number Guessing Game!");

        do {
            System.out.println("\nSelect Difficulty:");
            System.out.println("1. Easy (1–50)");
            System.out.println("2. Medium (1–100)");
            System.out.println("3. Hard (1–500)");

            int choice = scanner.nextInt();
            int range;

            switch (choice) {
                case 1:
                    range = 50;
                    break;
                case 2:
                    range = 100;
                    break;
                case 3:
                    range = 500;
                    break;
                default:
                    System.out.println("Invalid choice. Defaulting to Medium.");
                    range = 100;
            }

            NumberGuessingGame game = new NumberGuessingGame(range);
            game.startGame();

            System.out.print("\nDo you want to play again? (y/n): ");
            playAgain = scanner.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("\n👋 Thanks for playing!");
        scanner.close();
    }
}
