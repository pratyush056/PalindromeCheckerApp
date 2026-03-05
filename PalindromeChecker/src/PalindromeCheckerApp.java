import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Input text: ");
            String input = scanner.nextLine();

            PalindromeStrategy strategy = new DequeStrategy();
            PalindromeChecker checker = new PalindromeChecker(strategy);
            boolean result = checker.checkPalindrome(input);

            System.out.println("Is it a Palindrome? : " + result);

            scanner.close();
        }
}

interface PalindromeStrategy {
    boolean checkPalindrome(String str);
}

        class PalindromeChecker {
            private PalindromeStrategy strategy;
            public PalindromeChecker(PalindromeStrategy strategy) {
                this.strategy = strategy;
            }

            public boolean checkPalindrome(String input) {
                if (input == null || input.isEmpty()) return false;

                String clean = input.replaceAll("\\s+", "").toLowerCase();

                return strategy.checkPalindrome(clean);
            }

        }

class StackStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String str) {
        Deque<Character> deque = new LinkedList<>();

        for (char c : str.toCharArray()) {
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

    