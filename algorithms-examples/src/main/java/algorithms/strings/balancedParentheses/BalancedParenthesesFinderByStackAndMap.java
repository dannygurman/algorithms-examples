package algorithms.strings.balancedParentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedParenthesesFinderByStackAndMap implements BalancedParenthesesFinder{
    @Override
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');

        for (char currentChar : s.toCharArray()) {
            if (mapping.containsValue(currentChar)) {
                //put start Parentheses symbol
                stack.push(currentChar);
            } else if (mapping.containsKey(currentChar)) {
                if (stack.isEmpty() || mapping.get(currentChar) != stack.pop()) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
