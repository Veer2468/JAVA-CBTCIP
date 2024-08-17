import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        System.out.println("Welcome! I'm thinking of a number between 1 and 100. Can you guess it?");

        Scanner scanner = new Scanner(System.in);

        boolean continuePlaying;
        do {
            playGame();
            System.out.println("Would you like to give it another shot? Type Y to play again or N to quit.");
            String response = scanner.next();
            continuePlaying = response.equalsIgnoreCase("Y");
        } while (continuePlaying);

        System.out.println("Thanks for playing! See you next time.");
        scanner.close();
    }

    static void playGame() {
        int targetNumber = (int) (Math.random() * 100) + 1;
        int userGuess;
        int guessCount = 0;

        System.out.println();
        System.out.println("Alright, let's see if you can guess the number!");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            guessCount++;

            if (userGuess == targetNumber) {
                System.out.println("Congratulations! You've guessed the number in " + guessCount + " tries.");
                break;
            } else if (guessCount == 5) {
                System.out.println("Oops, you're out of guesses. The number I was thinking of was " + targetNumber + ".");
                break;
            } else if (userGuess < targetNumber && userGuess > 0) {
                System.out.println("Too low! Give it another try.");
            } else if (userGuess > targetNumber && userGuess < 101) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Your guess is out of range! Please guess a number between 1 and 100.");
            }
        }

        System.out.println();
    }
}