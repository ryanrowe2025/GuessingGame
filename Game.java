import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private int highestScore;

    public Game() {
        this.highestScore = Integer.MAX_VALUE;
    }

    public int play(Scanner scanner) {
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter the range of integers:");
            int start = getIntInput(scanner);
            int end = getIntInput(scanner);

            int number = generateRandomNumber(start, end);
            ArrayList<Integer> pastGuesses = new ArrayList<>();
            int numGuesses = 0;

            while (true) {
                System.out.println("Enter a guess:");
                int guess = getIntInput(scanner);

                if (pastGuesses.contains(guess)) {
                    System.out.println("You have already guessed this number. Try again.");
                    continue;
                }

                pastGuesses.add(guess);
                numGuesses++;

                if (guess == number) {
                    System.out.println("You guessed the correct number in " + numGuesses + " guesses!");
                    break;
                } else if (guess < number) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }
            }

            highestScore = Math.min(highestScore, numGuesses);
        }

        return highestScore;
    }

    private int getIntInput(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
        }
    }

    private int generateRandomNumber(int start, int end) {
        Random random = new Random();
        return random.nextInt(end - start + 1) + start;
    }
}