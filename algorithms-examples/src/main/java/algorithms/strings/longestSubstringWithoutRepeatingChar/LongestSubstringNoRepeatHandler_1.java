package algorithms.strings.longestSubstringWithoutRepeatingChar;

import java.util.HashSet;
import java.util.Set;

/**
 * Approach 1 - Set
 * We use a set (charSet) to keep track of unique characters in the current substring.
 * We maintain two pointers, left and right, to represent the boundaries of the current substring.
 * The maxLength variable keeps track of the length of the longest substring encountered so far.
 * We iterate through the string using the right pointer.
 *
 * If the current character is not in the set (charSet), it means we have a new unique character.
 *  * We insert the character into the set and update the maxLength if necessary.
 *
 * If the character is already present in the set, it indicates a repeating character within the current substring.
 * In this case, we move the left pointer forward, removing characters from the set until the repeating
 * character is no longer present.
 * We insert the current character into the set and continue the iteration.
 *
 * Finally, we return the maxLength as the length of the longest substring without repeating characters.
 */
public class LongestSubstringNoRepeatHandler_1 implements LongestSubstringNoRepeatHandler {

    @Override
    public int lengthOfLongestSubstring(final String str) {
        int strLength = str.length();
        int maxLength = 0;

        Set<Character> charSet = new HashSet<>();

        int left = 0;

        for (int right = 0; right < strLength; right++) {
            Character rightChar = str.charAt(right);
            if (!charSet.contains(rightChar)) {
                charSet.add(rightChar);
                int rightToLeftLength = right - left + 1;
                maxLength = Math.max(maxLength, rightToLeftLength);
            } else {
                while (charSet.contains(rightChar)) {
                    Character leftChar = str.charAt(left);
                    charSet.remove(leftChar);
                    left++;
                }
                charSet.add(rightChar);
            }
        }

        return maxLength;
    }
}

