import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Input text: ");
            String input = scanner.nextLine();

            PalindromeStrategy stackStrategy = new StackStrategy();
            PalindromeStrategy dequeStrategy = new DequeStrategy();

            PalindromeChecker stackChecker = new PalindromeChecker(stackStrategy);
            PalindromeChecker dequeChecker = new PalindromeChecker(dequeStrategy);

            long start1 = System.nanoTime();
            boolean result1 = stackChecker.checkPalindrome(input);
            long end1 = System.nanoTime();

            long start2 = System.nanoTime();
            boolean result2 = dequeChecker.checkPalindrome(input);
            long end2 = System.nanoTime();

            System.out.println("Stack Strategy Result: " + result1);
            System.out.println("Stack Execution Time: " + (end1 - start1) + " ns");

            System.out.println("Deque Strategy Result: " + result2);
            System.out.println("Deque Execution Time: " + (end2 - start2) + " ns");

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

    