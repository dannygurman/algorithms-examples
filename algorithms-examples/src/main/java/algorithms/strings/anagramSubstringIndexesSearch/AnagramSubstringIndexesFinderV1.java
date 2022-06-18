package algorithms.strings.anagramSubstringIndexesSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramSubstringIndexesFinderV1 implements AnagramSubstringIndexesFinder {

    @Override
    public List<Integer> findAnagramSubstringIndexes(String text, String pattern) {
        List<Integer> foundIndexes = new ArrayList<>();

        int patternLength = pattern.length();
        int textLength = text.length();

        char[] pattern_chars = pattern.toCharArray();

        //Sorting pattern chars!
        Arrays.sort(pattern_chars);

        // for storing the substring of length equal to patternLength
        char[] slidingWindow;

        for (int i = 0; i <= textLength - patternLength; i++) {
            //Remind-The substring begins at the specified beginIndex and extends to the character at index endIndex -1
            slidingWindow = text.substring(i, i + patternLength).toCharArray();

            //Sorting the temporal window!
            Arrays.sort(slidingWindow);

            if (Arrays.equals(slidingWindow, pattern_chars)) {
                System.out.println("Found at Index " + i);
                foundIndexes.add(i);
            }

        }

        return foundIndexes;
    }
}
