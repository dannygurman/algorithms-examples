package algorithms.strings.longestSubstringWithoutRepeatingChar_03;

import java.util.HashMap;
import java.util.Map;

/*Approach 2 - Unordered Map
        We improve upon the first solution by using an unordered map (charMap) instead of a set.

        The map stores characters as keys and their indices as values.

        We still maintain the left and right pointers and the maxLength variable.

        We iterate through the string using the right pointer.

        If the current character is not in the map or its index is less than left,
        it means it is a new unique character.
         We update the charMap with the character's index and update the maxLength if necessary.

        If the character is repeating within the current substring,
        we move the left pointer to the next position after the last occurrence of the character.
        We update the index of the current character in the charMap and continue the iteration.

        At the end, we return the maxLength as the length of the longest substring without repeating characters.*/
public class LongestSubstringNoRepeatHandler_2 implements LongestSubstringNoRepeatHandler {

    public int lengthOfLongestSubstring(String str) {
        int n = str.length();
        int maxLength = 0;
        Map<Character, Integer> charToLastOccurrenceIndex = new HashMap<>();
        int leftInd = 0;

        for (int rightInd = 0; rightInd < n; rightInd++) {
            Character charAtRight = str.charAt(rightInd);
            //checking if in NOT in map (never face this char before) ,
            // or in map before the left index - so it does NOT affect current sub string
            if ( ! charToLastOccurrenceIndex.containsKey(charAtRight)
                    || charToLastOccurrenceIndex.get(charAtRight) < leftInd) {
                //Update map last occurrence for charAtRight to current index
                charToLastOccurrenceIndex.put(charAtRight, rightInd);

                int rightToLeftLength = rightInd - leftInd + 1;
                maxLength = Math.max(maxLength, rightToLeftLength);
            } else {
                //Moving left index to last occurrence of right char + 1
                leftInd = charToLastOccurrenceIndex.get(charAtRight) + 1;

                //Update map last occurrence for charAtRight to current index
                charToLastOccurrenceIndex.put(charAtRight, rightInd);
            }
        }

        return maxLength;
    }
}
