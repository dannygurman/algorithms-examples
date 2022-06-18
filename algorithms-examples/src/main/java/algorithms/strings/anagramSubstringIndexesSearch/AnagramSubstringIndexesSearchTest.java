package algorithms.strings.anagramSubstringIndexesSearch;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AnagramSubstringIndexesSearchTest {

    @Test
    public void when_AnagramSubstringIndexesSearch_V1_Then_IndexesFound_V1() {
        anagramSubstringIndexesSearch_Then_IndexesFound_Internal(new AnagramSubstringIndexesFinderV1());
    }

    @Test
    public void when_AnagramSubstringIndexesSearch_V1_Then_IndexesFound_V2() {
        anagramSubstringIndexesSearch_Then_IndexesFound_Internal(new AnagramSubstringIndexesFinderV2());
    }

    private void anagramSubstringIndexesSearch_Then_IndexesFound_Internal(AnagramSubstringIndexesFinder anagramSubstringCountFinder) {
        String text = "BACDGABCDA";
        String pattern = "ABCD";
        List<Integer> expectedIndexes = List.of(0, 5, 6);
        List<Integer>  matchingIndexesInText = anagramSubstringCountFinder.findAnagramSubstringIndexes(text, pattern);
        Assert.assertEquals("Indexes found not match expected", expectedIndexes , matchingIndexesInText);
    }
}
