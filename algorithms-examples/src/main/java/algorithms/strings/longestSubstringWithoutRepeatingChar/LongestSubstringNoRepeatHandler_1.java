package algorithms.strings.longestSubstringWithoutRepeatingChar;

import java.util.HashSet;
import java.util.Set;

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

