import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileEncryptionApp {

    private Scanner scanner;
    private ArrayList<Character> list;
    private ArrayList<Character> shuffledList;

    // Constructor to initialize the class and start the process
    public FileEncryptionApp() {
        scanner = new Scanner(System.in);
        list = new ArrayList<>();
        shuffledList = new ArrayList<>();
        newKey(); // Generate a new encryption key
        askUser(); // Start asking user for actions (encrypt, decrypt, etc.)
    }

    // Main method to start the application
    public static void main(String[] args) {
        new FileEncryptionApp(); // Start the program by creating an instance
    }

    // Method to prompt the user for input (Encrypt, Decrypt, or Quit)
    private void askUser() {
        while (true) {
            System.out.println("Do you want to (E)ncrypt or (D)ecrypt a file? (Q)uit to exit");
            char choice = Character.toUpperCase(scanner.nextLine().charAt(0));
            switch (choice) {
                case 'E':
                    processFile(true); // Encrypt
                    break;
                case 'D':
                    processFile(false); // Decrypt
                    break;
                case 'Q':
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid option. Please enter E, D, or Q.");
                    break;
            }
        }
    }

    // Method to generate a new encryption key by shuffling characters
    private void newKey() {
        list.clear();
        shuffledList.clear();
        for (int i = 32; i < 127; i++) { // ASCII range from 32 to 126
            list.add((char) i);
        }
        shuffledList = new ArrayList<>(list);
        Collections.shuffle(shuffledList); // Shuffle to create an encryption key
        System.out.println("Encryption key generated.");
    }

    // Method to process a file, either encrypting or decrypting it based on user input
    private void processFile(boolean encrypt) {
        try {
            // Get input file path from the user
            System.out.println("Enter the input file path:");
            String inputFilePath = scanner.nextLine();

            // Get output file path from the user
            System.out.println("Enter the output file path:");
            String outputFilePath = scanner.nextLine();

            // Read content from the input file
            String content = readFile(inputFilePath);
            if (content == null) {
                System.out.println("Error reading file.");
                return;
            }

            // Encrypt or decrypt the content
            String result = encrypt ? encryptContent(content) : decryptContent(content);

            // Write the result to the output file
            writeFile(outputFilePath, result);
            System.out.println((encrypt ? "Encryption" : "Decryption") + " successful. Output saved to " + outputFilePath);

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Method to encrypt the content of the file
    private String encryptContent(String content) {
        char[] letters = content.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < list.size(); j++) {//"C:\Users\Andrew Boateng\Desktop\Business.txt"    
                if (letters[i] == list.get(j)) {//"C:\Users\Andrew Boateng\Desktop\Another.txt"
                    letters[i] = shuffledList.get(j);
                    break;
                }
            }
        }
        return new String(letters);
    }

    // Method to decrypt the content of the file
    private String decryptContent(String content) {
        char[] letters = content.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < shuffledList.size(); j++) {
                if (letters[i] == shuffledList.get(j)) {
                    letters[i] = list.get(j);
                    break;
                }
            }
        }
        return new String(letters);
    }

    // Method to read the content of a file
    private String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("File reading error: " + e.getMessage());
            return null;
        }
        return content.toString();
    }

    // Method to write the encrypted or decrypted content to a file
    private void writeFile(String filePath, String content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(content);
        } catch (IOException e) {
            System.out.println("File writing error: " + e.getMessage());
        }
    }
}
