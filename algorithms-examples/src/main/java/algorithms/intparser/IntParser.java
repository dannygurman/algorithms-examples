package algorithms.intparser;

public class IntParser {


    public static int parseInt(final String intStr) {
        int result = 0;
        char[] numberChars = intStr.toCharArray();
        int multiplier = 1;
        for (int i = numberChars.length-1; i >= 0; i--) {
            char digitChar = numberChars[i];
            int digit = toDigit(digitChar);
            result += digit * multiplier;
            multiplier *= 10;
        }
        return result;
    }

        private static int toDigit(final char digitChar){
            return(digitChar - '0');
        }

}
