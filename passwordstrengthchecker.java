import java.util.Scanner;

public class passwordstrengthchecker {
    public static void main(String[] arg) {
        Scanner userInput = new Scanner(System.in);
        int passwordLength = 8;
        char ch;
        int lowerCasePass = 0, upperCasePass = 0, digit = 0, special = 0;

        System.out.println("Enter your password:");
        String password = userInput.nextLine();
        int total = password.length();

        if (total < passwordLength) {
            System.out.println("Password is invalid, it should be at least " + passwordLength + " characters long.");
            return;
        } else {
            for (int i = 0; i < total; i++) {
                ch = password.charAt(i);

                if (Character.isUpperCase(ch)) 
                    upperCasePass = 1;
                else if (Character.isLowerCase(ch)) 
                    lowerCasePass = 1;
                else if (Character.isDigit(ch)) 
                    digit = 1;
                else 
                    special = 1;
            }
        }

        if (upperCasePass == 1 && lowerCasePass == 1 && digit == 1 && special == 1) {
            System.out.println("Your password is strong.");
        } else {
            System.out.println("The password is not strong enough.");
        }

        userInput.close(); // Don't forget to close the scanner
    }
}
