package GradeCalculater;

import java.util.Scanner;

public class GradeCalculator {
    public static String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int subjects = scanner.nextInt();
        double[] marks = new double[subjects];
        
        for (int i = 0; i < subjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            double mark = scanner.nextDouble();
            while (mark < 0 || mark > 100) {
                System.out.println("Invalid input! Marks should be between 0 and 100.");
                System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
                mark = scanner.nextDouble();
            }
            marks[i] = mark;
        }
        
        double totalMarks = 0;
        for (double mark : marks) {
            totalMarks += mark;
        }
        
        double averagePercentage = totalMarks / subjects;
        String grade = calculateGrade(averagePercentage);
        
        System.out.println("\n--- Student Result ---");
        System.out.println("Total Marks: " + totalMarks + "/" + (subjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }
}

