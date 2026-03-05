import java.util.LinkedList;
import java.util.Scanner;

public class PalindromeCheckerApp {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Input text: ");
            String input = scanner.nextLine();

            PalindromeChecker checker = new PalindromeChecker();
            boolean result = checker.checkPalindrome(input);

            System.out.println("Is it a Palindrome? : " + result);

            scanner.close();
        }
}


        class PalindromeChecker {

            public boolean checkPalindrome(String input) {
                if (input == null || input.isEmpty()) return false;

                String clean = input.replaceAll("\\s+", "").toLowerCase();

                return check(clean, 0, clean.length() - 1);
            }

            private boolean check(String str, int start, int end) {
                if (start >= end)
                    return true;

                if (str.charAt(start) != str.charAt(end))
                    return false;

                return check(str, start + 1, end - 1);
            }
        }
    