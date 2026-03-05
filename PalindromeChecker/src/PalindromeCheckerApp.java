import java.util.LinkedList;
import java.util.Scanner;
import java.util.LinkedList;

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

            LinkedList<Character> list = new LinkedList<>();

            for (char c : clean.toCharArray()) {
                list.add(c);
            }

            LinkedList<Character> reversed = new LinkedList<>(list);
            java.util.Collections.reverse(reversed);

            if (!list.equals(reversed)) {
                return false;
            }

            return true;
        }
    }

