package algorithms.strings.anagramSubstringIndexesSearch;

import algorithms.utils.AlgorithmUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramSubstringIndexesFinderV2 implements AnagramSubstringIndexesFinder {

    //The maximum number of characters that can be represented in extended ASCII  is 256
    private final static int MAX_SUPPORTED_CHARACTERS = 256;

    @Override
    public List<Integer> findAnagramSubstringIndexes(String text, String pattern) {

        List<Integer> foundIndexes = new ArrayList<>();

        int patternLength = pattern.length();
        int textLength = text.length();

        //Store count of all characters of pattern, The array index match chars index
        char[] charsCountInPattern = new char[MAX_SUPPORTED_CHARACTERS];
        char[] charsCountInSlidingWindow = new char[MAX_SUPPORTED_CHARACTERS];

        for (int i = 0; i < patternLength; i++) {
            (charsCountInPattern[pattern.charAt(i)])++;
            (charsCountInSlidingWindow[text.charAt(i)])++;
        }

        // Traverse through remaining characters of pattern
        for (int i = patternLength; i < textLength; i++) {
            // Compare counts of current window of text with counts of pattern
            if (AlgorithmUtils.isArraysEqual(charsCountInPattern, charsCountInSlidingWindow)) {
                onFound((i-patternLength), foundIndexes);
            }

            // Add current character to current window
            (charsCountInSlidingWindow[text.charAt(i)])++;

            // Remove the first character of previous window
            (charsCountInSlidingWindow[text.charAt(i - patternLength)])--;
        }

        // Check for the last window in text
        if (AlgorithmUtils.isArraysEqual(charsCountInPattern, charsCountInSlidingWindow))
            onFound((textLength-patternLength), foundIndexes);

        return foundIndexes;
    }



    private static void onFound(int index, List<Integer> foundIndexes) {
        System.out.println("Found at Index " + index);
        foundIndexes.add(index);
    }
}

/*
// Java program to search all anagrams
// of a pattern in a text
public class GFG
{
    static final int MAX = 256;

    // This function returns true if contents
    // of arr1[] and arr2[] are same, otherwise
    // false.
    static boolean compare(char arr1[], char arr2[])
    {
        for (int i = 0; i < MAX; i++)
            if (arr1[i] != arr2[i])
                return false;
        return true;
    }
*/

  /*  // This function search for all permutations
    // of pat[] in txt[]
    static void search(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();

        // countP[]:  Store count of all
        // characters of pattern
        // countTW[]: Store count of current
        // window of text
        char[] countP = new char[MAX];
        char[] countTW = new char[MAX];
        for (int i = 0; i < M; i++)
        {
            (countP[pat.charAt(i)])++;
            (countTW[txt.charAt(i)])++;
        }

        // Traverse through remaining characters
        // of pattern
        for (int i = M; i < N; i++)
        {
            // Compare counts of current window
            // of text with counts of pattern[]
            if (compare(countP, countTW))
                System.out.println("Found at Index " +
                        (i - M));

            // Add current character to current
            // window
            (countTW[txt.charAt(i)])++;

            // Remove the first character of previous
            // window
            countTW[txt.charAt(i-M)]--;
        }

        // Check for the last window in text
        if (compare(countP, countTW))
            System.out.println("Found at Index " +
                    (N - M));
    }*/