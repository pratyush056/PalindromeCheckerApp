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
            if (input == null) return false;

            String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            int length = clean.length();

            for (int i = 0; i < length / 2; i++) {
                if (clean.charAt(i) != clean.charAt(length - 1 - i)) {
                    return false;
            }
        }

            return true;
    }
}
