import java.util.Scanner;

public class task1 {

    public static void main(String[] args) {
        // A program that converts temperatures from celsius to fahrenheit and vice
        // versa

        // Declaring constant values
        double conversion_Factor_between_CelsiusAndFahreheit = 9.0 / 5;
        double conversion_Factor_between_FahrenheitAndCelsius = 5.0 / 9;

        // Taking inputs from user
        Scanner userInput = new Scanner(System.in);
        System.out.println("Is your temperature in C/F ?");
        // saving user input.
        String Unit = userInput.nextLine();

        // Checking for conditions
        if (Unit.equalsIgnoreCase("C")) {
            System.out.println("what is your temperature reading");
            Double temperature = userInput.nextDouble();
            // converting from clsius to fahrenheit
            double fahrenheit = ((conversion_Factor_between_CelsiusAndFahreheit * temperature) + 32);
            // Displaying results
            System.out.println("Your temperature is reading at " + fahrenheit + "F");

        } else if (Unit.equalsIgnoreCase("F")) {
            System.out.println("What is your temperature ");
            // Saving user inputs
            double tempCelsius = userInput.nextDouble();
            //Converting from Fahrenheit to celsius
            double celsius = ((tempCelsius - 32) * conversion_Factor_between_FahrenheitAndCelsius);
            // Displaying result
            System.out.println("Your temperature is " + celsius + "C");

        }
        // Asking the user to renter unit after entering an invalid Unit.
        else {
            System.out.println("You entered an invalid unit: Enter again");
        }

    }
}