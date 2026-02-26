import java.util.LinkedList;
import java.util.Scanner;
import java.util.Deque;

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

            Deque<Character> deque = new LinkedList<>();

            for (char c : clean.toCharArray()) {
                deque.addLast(c);
            }

            while (deque.size() > 1) {
                if (!deque.removeFirst().equals(deque.removeLast())) {
                    return false;
                }
            }

            return true;
        }
    }

