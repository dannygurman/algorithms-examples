package algorithms.arrays.findMaxIntervalsOverlap;

import algorithms.arrays.findMaxIntervalsOverlap.verA.MaxIntervalsOverlapFinderVerA;
import algorithms.arrays.findMaxIntervalsOverlap.verB.MaxIntervalsOverlapFinderVerB;
import algorithms.arrays.findMaxIntervalsOverlap.verC.MaxIntervalsOverlapFinderVerC;
import org.junit.Assert;
import org.junit.Test;

public class MaxIntervalsOverlapFinderTest {


    @Test
    public void testVerA() {
        MaxIntervalsOverlapFinder maxIntervalsOverlapFinder = new MaxIntervalsOverlapFinderVerA();
        testInternal(maxIntervalsOverlapFinder);
    }

    @Test
    public void testVerB() {
        MaxIntervalsOverlapFinder maxIntervalsOverlapFinder = new MaxIntervalsOverlapFinderVerB();
        testInternal(maxIntervalsOverlapFinder);
    }


    @Test
    public void testVerC() {
        MaxIntervalsOverlapFinder maxIntervalsOverlapFinder = new MaxIntervalsOverlapFinderVerC();
        testInternal(maxIntervalsOverlapFinder);
    }

    private void testInternal(MaxIntervalsOverlapFinder maxIntervalsOverlapFinder){
        int [] arriveTimes  = {1, 2, 9, 5, 5};
        int [] exitTimes = {4, 5, 12, 9, 12};

        int foundMaxGuests = maxIntervalsOverlapFinder.findMaxGuests(arriveTimes, exitTimes);
        Assert.assertEquals(5, foundMaxGuests);
    }
}
