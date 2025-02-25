package QuizApp;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApp {
    private static final String[][] quizData = {
        {"Which keyword is used to define a class in Java?", "class", "define", "struct", "className", "1"},
        {"Which of these is not a primitive data type?", "int", "float", "boolean", "String", "4"},
        {"What is the default value of an int variable?", "0", "null", "undefined", "-1", "1"},
        {"Which method is called when an object is created?", "main()", "start()", "constructor", "init()", "3"},
        {"Which package is automatically imported in every Java program?", "java.util", "java.lang", "java.io", "java.net", "2"}
    };

    private static int score = 0;
    private static int questionIndex = 0;
    private static boolean answered = false;
    private static Timer timer;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.println("Welcome to the Java Quiz!\n");
        askQuestion();
    }

    private static void askQuestion() {
        if (questionIndex >= quizData.length) {
            System.out.println("\nQuiz Completed! Your final score: " + score + " / " + quizData.length);
            scanner.close();
            return;
        }

        String[] question = quizData[questionIndex];
        System.out.println("\n" + (questionIndex + 1) + ". " + question[0]);
        for (int i = 1; i <= 4; i++) {
            System.out.println(i + ". " + question[i]);
        }

        answered = false;
        startTimer();
        getUserAnswer(question[5]);
    }

    private static void startTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!answered) {
                    System.out.println("\nTime's up! Moving to the next question...");
                    nextQuestion();
                }
            }
        }, 10000);
    }

    private static void getUserAnswer(String correctAnswer) {
        System.out.print("Enter your choice (1-4): ");
        int userAnswer;
        
        try {
            userAnswer = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("\nInvalid input! Moving to the next question...");
            scanner.nextLine();
            nextQuestion();
            return;
        }

        timer.cancel();
        answered = true;

        if (String.valueOf(userAnswer).equals(correctAnswer)) {
            System.out.println("Correct!\n");
            score++;
        } else {
            System.out.println("Wrong! The correct answer was option " + correctAnswer + ".\n");
        }
        nextQuestion();
    }

    private static void nextQuestion() {
        questionIndex++;
        askQuestion();
    }
}


