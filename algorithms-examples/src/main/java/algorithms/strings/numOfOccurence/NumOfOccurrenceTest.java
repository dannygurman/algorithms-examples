package algorithms.strings.numOfOccurence;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class NumOfOccurrenceTest {

    @Test
    public void when_NumOfOccurrenceCalled_Naive_Then_Found() {
        NumOfOccurrenceFinder finder = new NumOfOccurrenceFinderNaive();
        testInternal(finder);
    }

    @Test
    public void when_NumOfOccurrenceCalled_ByRecursion_Then_Found() {
        NumOfOccurrenceFinder finder = new NumOfOccurrenceFinderByRecursion();
        testInternal(finder);
    }

    private void testInternal(NumOfOccurrenceFinder finder) {
        int arr[] = {1, 2, 2, 2, 2, 3, 4, 7 ,8 ,8 };
        int x = 2;
        int result = finder.countOccurrences(arr, x);
        assertEquals(4, result);
    }
}
