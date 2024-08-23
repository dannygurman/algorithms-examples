package algorithms.strings.balancedParentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static java.util.Map.entry;

public class BalancedParenthesesFinderByStackAndMap implements BalancedParenthesesFinder {

    //mapping close symbol to matching open Parentheses symbol
    private Map<Character, Character> closeSymbolToOpenSymbol = Map.ofEntries(
            entry(')', '('),
            entry('}', '{'),
            entry(']', '[')
    );


    @Override
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char currentChar : s.toCharArray()) {
            //check if current char is Parentheses open value
            if (closeSymbolToOpenSymbol.containsValue(currentChar)) {
                //put start Parentheses symbol
                stack.push(currentChar);
            } else if (closeSymbolToOpenSymbol.containsKey(currentChar)) {
                if (stack.isEmpty() ||
                        closeSymbolToOpenSymbol.get(currentChar) != stack.pop()) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
