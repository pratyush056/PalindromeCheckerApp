import java.util.LinkedList;
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

            String clean = input.replaceAll("\\s+", "").toLowerCase();


            return checkPalindrome(clean, 0, clean.length() - 1);

            
        }

        public static boolean checkPalindrome(String str, int start, int end) {
            if (start >= end)
                return true;

            if (str.charAt(start) != str.charAt(end))
                return false;

            return checkPalindrome(str, start + 1, end - 1);
        }
    }