import java.util.Scanner;

public class Pallindrome_checker{

    public static void main(String[] args) {
        // Accepting the user input( Enter a word or a phrase).
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word or a phrase");
        String Word_Phrase;
        Word_Phrase = scanner.nextLine().replaceAll("[^a-zA-Z]", "");
        // Displaying user inputs and its length
        System.out.println(Word_Phrase);
        int i = 0;
        int j = Word_Phrase.length() - 1;
        boolean is_Pallindrome = true;
        // comparing chracters untill they are equal
        while (i < j) {
            char chooseAt_i = Word_Phrase.charAt(i);
            char chooseAt_j = Word_Phrase.charAt(j);

            if (chooseAt_i != chooseAt_j) {
                is_Pallindrome = false;
                break;
            }
            i++;
            j--;
        }

        if (is_Pallindrome) {
            System.out.println("This is a palindrome.");
        } else {
            System.out.println("This word or phrase is not a palindrome.");
        }

    }
}
