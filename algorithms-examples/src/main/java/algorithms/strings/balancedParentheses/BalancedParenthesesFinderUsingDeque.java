package algorithms.strings.balancedParentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParenthesesFinderUsingDeque implements BalancedParenthesesFinder {

    @Override
    public boolean isValid(String expression) {
        // Using ArrayDeque is faster than using Stack class
        Deque<Character> bracketscharsDeque = new ArrayDeque<>();

        // Traversing the Expression
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                // Push the element in the stack
                bracketscharsDeque.push(currentChar);
                //skip
                continue;
            }

             if (currentChar != ')' && currentChar != ']' && currentChar != '}') {
                //skip
                continue;
            }

            char poppedChar = bracketscharsDeque.pop();
            switch (currentChar) {
                case ')':
                    if (poppedChar != '(') {
                        return false;
                    }
                    break;

                case '}':
                    if (poppedChar != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (poppedChar != '[') {
                        return false;
                    }
                    break;
            }
        }

        // Check Empty Stack
        return (bracketscharsDeque.isEmpty());
    }
}
