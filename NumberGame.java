package NumberGame;

import java.util.*;

public class NumberGame {
public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;

        
        Map<String, Integer> difficultyLevels = new HashMap<>();
        difficultyLevels.put("Easy", 10);
        difficultyLevels.put("Medium", 5);
        difficultyLevels.put("Hard", 3);

       
        TreeSet<Integer> scoreBoard = new TreeSet<>(Collections.reverseOrder());

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            System.out.println("\nChoose Difficulty Level: Easy, Medium, Hard");
            System.out.print("Enter difficulty: ");
            String difficulty = scanner.next();
            int maxAttempts = difficultyLevels.getOrDefault(difficulty, 5);

            int randomNumber = random.nextInt(100) + 1; 
            int attemptsLeft = maxAttempts;
            boolean guessedCorrectly = false;

            
            Queue<Integer> pastGuesses = new LinkedList<>();

            System.out.println("\nI have chosen a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attemptsLeft > 0) {
                System.out.print("\nEnter your guess: ");
                int userGuess = scanner.nextInt();

                
                pastGuesses.add(userGuess);

                if (userGuess == randomNumber) {
                    System.out.println("Correct! You guessed the number.");
                    guessedCorrectly = true;
                    totalScore += attemptsLeft * 10; 
                    scoreBoard.add(totalScore);
                    break;
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Too low!");
                }

                attemptsLeft--;
                System.out.println("Attempts left: " + attemptsLeft);
                System.out.println("Your past guesses: " + pastGuesses);
            }

            if (!guessedCorrectly) {
                System.out.println("\nGame Over! The correct number was: " + randomNumber);
            }

            System.out.println("Your total score: " + totalScore);
            System.out.println("Scoreboard: " + scoreBoard);
            System.out.print("Play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("\nThanks for playing! Final Scoreboard: " + scoreBoard);
        scanner.close();

	}
}
