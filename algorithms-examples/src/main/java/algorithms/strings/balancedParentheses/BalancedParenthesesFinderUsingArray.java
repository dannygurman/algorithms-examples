package algorithms.strings.balancedParentheses;

public class BalancedParenthesesFinderUsingArray implements BalancedParenthesesFinder {

    @Override
    public boolean isValid(String expression) {
        int i = -1;
        char[] openBracketsArray = new char[expression.length()];
        for (char currentChar : expression.toCharArray()) {
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                openBracketsArray[++i] = currentChar;
            } else {
                char charInArrayInMatchIndex = openBracketsArray[i];
                if (i >= 0
                        && (
                        (charInArrayInMatchIndex == '(' && currentChar == ')')
                                || (charInArrayInMatchIndex == '{' && currentChar == '}')
                                || (charInArrayInMatchIndex == '[' && currentChar == ']'))
                )
                    i--;
                else
                    return false;
            }
        }
        return i == -1;
    }
}
