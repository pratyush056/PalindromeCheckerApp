import java.util.Scanner;
public class PalindromeCheckerApp {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Input text: ");
            String input = scanner.nextLine();

            boolean result = isPalindrome(input);

            System.out.println("Is it a Palindrome? : " + result);

            scanner.close();
        }

        public static boolean isPalindrome(String input) {
            if (input == null || input.isEmpty()) return false;

            String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            String reversed = "";

            for (int i = clean.length() - 1; i >= 0; i--) {
                reversed += clean.charAt(i);
            }

            return clean.equals(reversed);
        }
    }

