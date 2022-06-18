package algorithms.phoneLettersCominations;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {
    //Given a digit String , return all possible letter combination that number could represent
    // A mapping of digit to number like Telephone is given

    private static final String[] MAPPING = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        String digits = "23";
        List results = LetterCombinationOfPhoneNumber.letterCombinations(digits);
        results.forEach(str -> System.out.println(str));
    }


    public static List<String> letterCombinations(String digits) {
        LinkedList<String> foundCombinations = new LinkedList<>();
        foundCombinations.add("");
        for (int i = 0; i < digits.length(); i++) {
            int digit = Character.getNumericValue(digits.charAt(i));
            String matchingStringInMapForDigit = MAPPING[digit];
            char[] charsInDigitMapping = matchingStringInMapForDigit.toCharArray();

            // Retrieves, but does not remove, the head (first element) of this list
            //While left combination that not appended with current char
            while (foundCombinations.peek().length() == i) {
                //Retrieving + REMOVING first element in list
                String firstCombinationInFound = foundCombinations.remove();

                for (char char1 : charsInDigitMapping) {
                    foundCombinations.add(firstCombinationInFound + char1);
                }
            }

        }
        return foundCombinations;
    }
}
