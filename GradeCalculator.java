import java.util.Scanner;

public class GradeCalculator {

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = input.nextInt();

        int[] marks = new int[numSubjects];

        System.out.println("Enter the marks obtained in each subject (out of 100):");
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = input.nextInt();
        }

        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }

        double averagePercentage = (double) totalMarks / numSubjects;

        char grade = calculateGrade(averagePercentage);

        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        input.close();
    }

    public static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}