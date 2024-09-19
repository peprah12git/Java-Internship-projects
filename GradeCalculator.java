import java.util.Scanner;

public class GradeCalculator {

    //  calculating the average grade method function
    public static double calculate_Average(int numGrades, Scanner scanner) {
        double total = 0;

        // Loop to input each grade and add it to the total
        for (int i = 1; i <= numGrades; i++) {
            System.out.print("Enter grade " + i + ": ");
            double Grade = scanner.nextDouble();
            total = total +Grade;
        }
        // Calculate and return the average
        return total / numGrades;
    }
    // Main method for user input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the number of grades
        System.out.print("Enter the number of grades: ");
        int numberOfGrades = scanner.nextInt();

        // checking out for valid grades
        if (numberOfGrades <= 0) {
            System.out.println("Invalid number of grades. Please enter a positive number.");
        } else {
            // Calculate the average 
            double average = calculate_Average(numberOfGrades, scanner);
            //displaying it
            System.out.printf("\nThe average grade is: %.2f", average);
        }

        // Closing the scanner 
        scanner.close();
    }
}

