import java.util.Scanner;
import java.util.Random;

public class RandomPasswordGenerator {

    // Changed return type to String
    public String numberGenerator() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Enter the length of the password
        System.out.println("Enter the length of your password:");
        int passwordLength = scanner.nextInt();
        scanner.nextLine(); // Consume leftover newline after nextInt()

        // Enter the character types
        System.out.println("Include lower letters? (yes/No):");
        String include_lower_letters = scanner.nextLine().toLowerCase();

        System.out.println("Include upper case letters? (yes/No):");
        String include_UpperCase = scanner.nextLine().toLowerCase(); // Consistent case comparison

        System.out.println("Include numbers? (yes/No):");
        String include_numbers = scanner.nextLine().toLowerCase();

        System.out.println("Include special characters? (yes/No):");
        String include_special_character = scanner.nextLine().toLowerCase();

        // Define character sets based on user input
        String lowercase_letters = "abcdefghijklmnopqrstuvwxyz";
        String uppercase_letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String special_characters = "!@#$%^&*()-_=+[]{}|;:,.<>?/";

        // Initialize character pool
        String characterPool = "";

        // Add character types to the pool based on user input
        if (include_lower_letters.equals("yes")) {
            characterPool += lowercase_letters;
        }
        if (include_UpperCase.equals("yes")) {
            characterPool += uppercase_letters;
        }
        if (include_numbers.equals("yes")) {
            characterPool += numbers;
        }
        if (include_special_character.equals("yes")) {
            characterPool += special_characters;
        }

        // Ensure that the character pool is not empty
        if (characterPool.isEmpty()) {
            System.out.println("Alert! No character types selected. Please choose at least one.");
            return null;
        }

        // Use StringBuilder for password generation
        StringBuilder generatedPassword = new StringBuilder();

        // Generate each character of the password
        for (int i = 0; i < passwordLength; i++) {
            int random_index = random.nextInt(characterPool.length());
            generatedPassword.append(characterPool.charAt(random_index));
        }

        // Return the generated password as a string
        return generatedPassword.toString();
    }

    public static void main(String[] args) {
        // Correct object instantiation and variable name
        RandomPasswordGenerator generator = new RandomPasswordGenerator();
        String password = generator.numberGenerator();

        if (password != null) {
            System.out.println("Generated password: " + password);
        }
    }
}
