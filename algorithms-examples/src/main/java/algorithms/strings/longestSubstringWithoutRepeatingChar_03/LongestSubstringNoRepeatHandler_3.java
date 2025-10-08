package algorithms.strings.longestSubstringWithoutRepeatingChar_03;

import java.util.Arrays;

/**
 * Approach 3 - Integer Array
 * This solution uses an integer array charIndex to store the indices of characters.
 *
 * We eliminate the need for an unordered map by utilizing the array.
 *
 * The maxLength, left, and right pointers are still present.
 *
 * We iterate through the string using the right pointer.
 *
 * We check if the current character has occurred within the current substring by comparing
 * its index in charIndex with left.
 * If the character has occurred, we move the left pointer to the next position after the
 * last occurrence of the character.
 *
 * We update the index of the current character in charIndex.
 *
 * At each step, we update the maxLength by calculating the length of the current substring.
 *
 * We continue the iteration until reaching the end of the string.
 *
 * Finally, we return the maxLength as the length of the longest substring without repeating characters.
 */
public class LongestSubstringNoRepeatHandler_3 implements LongestSubstringNoRepeatHandler {
    @Override
    public int lengthOfLongestSubstring(String str) {
        int n = str.length();
        int maxLength = 0;

        //array index is the matching char value , the value is last occurrence
        int[] charIndex = new int[128];
        //init array
        Arrays.fill(charIndex, -1);

        int leftInd = 0;

        for (int rightInd = 0; rightInd < n; rightInd++) {
            Character charAtRight = str.charAt(rightInd);
            if (charIndex[charAtRight] >= leftInd) {
                leftInd = charIndex[charAtRight] + 1;
            }
            charIndex[charAtRight] = rightInd;
            int rightToLeftLength = rightInd - leftInd + 1;
            maxLength = Math.max(maxLength, rightToLeftLength);
        }

        return maxLength;
    }
}
