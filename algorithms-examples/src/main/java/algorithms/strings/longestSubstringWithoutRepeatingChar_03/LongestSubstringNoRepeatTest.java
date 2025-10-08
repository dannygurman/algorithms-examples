package algorithms.strings.longestSubstringWithoutRepeatingChar_03;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubstringNoRepeatTest {

    @Test
    public void testLongestSubstringNoRepeatTest_Approach1(){
        LongestSubstringNoRepeatHandler longestSubstringNoRepeatHandler = new LongestSubstringNoRepeatHandler_1();
        verifyLongestSubstringNoRepeatInternal(longestSubstringNoRepeatHandler);
    }

    @Test
    public void testLongestSubstringNoRepeatTest_Approach2(){
        LongestSubstringNoRepeatHandler longestSubstringNoRepeatHandler = new LongestSubstringNoRepeatHandler_2();
        verifyLongestSubstringNoRepeatInternal(longestSubstringNoRepeatHandler);
    }

    @Test
    public void testLongestSubstringNoRepeatTest_Approach3(){
        LongestSubstringNoRepeatHandler longestSubstringNoRepeatHandler = new LongestSubstringNoRepeatHandler_3();
        verifyLongestSubstringNoRepeatInternal(longestSubstringNoRepeatHandler);
    }

    private void verifyLongestSubstringNoRepeatInternal(LongestSubstringNoRepeatHandler longestSubstringNoRepeatHandler){
        verifyLongestSubstringNoRepeatInternal(longestSubstringNoRepeatHandler,"abcabcbb", 3);
        verifyLongestSubstringNoRepeatInternal(longestSubstringNoRepeatHandler,"bbbbb", 1);
        verifyLongestSubstringNoRepeatInternal(longestSubstringNoRepeatHandler,"pwwkew", 3);
    }

    private void verifyLongestSubstringNoRepeatInternal(LongestSubstringNoRepeatHandler longestSubstringNoRepeatHandler,
                                                        String text, int expectedLength) {
        int actualLength = longestSubstringNoRepeatHandler.lengthOfLongestSubstring(text);
        Assert.assertEquals("length not as expected", expectedLength, actualLength);
    }
}
