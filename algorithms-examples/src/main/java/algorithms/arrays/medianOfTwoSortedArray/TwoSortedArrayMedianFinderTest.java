package algorithms.arrays.medianOfTwoSortedArray;

import algorithms.arrays.medianOfTwoSortedArray.countingWhileMerging.TwoSortedArrayMedianFinder_CountingWhileMerging;
import algorithms.arrays.medianOfTwoSortedArray.mergingExtraSpace.TwoSortedArrayMedianFinder_MergingWithExtraSpace;
import org.junit.Assert;
import org.junit.Test;

public class TwoSortedArrayMedianFinderTest {

    @Test
    public void testTwoSortedArrayMedianFinder_MergingWithExtraSpace(){
        TwoSortedArrayMedianFinder twoSortedArrayMedianFinder = new TwoSortedArrayMedianFinder_MergingWithExtraSpace();
        verifyTwoSortedArrayMedianFinderInternal(twoSortedArrayMedianFinder);
    }

    @Test
    public void testTwoSortedArrayMedianFinder_CountingWhileMerging(){
        TwoSortedArrayMedianFinder twoSortedArrayMedianFinder = new TwoSortedArrayMedianFinder_CountingWhileMerging();
        verifyTwoSortedArrayMedianFinderInternal(twoSortedArrayMedianFinder);
    }


    public void verifyTwoSortedArrayMedianFinderInternal(TwoSortedArrayMedianFinder twoSortedArrayMedianFinder){
        int [] array1 = new int[]{1,3,4,6,9};
        int [] array2 = new int[]{2,5,7,8,10};
        double expectedMedian = 5.5;
        double foundMedian = twoSortedArrayMedianFinder.getSortedArraysMedian(array1, array2);
        Assert.assertEquals("median not as expected", expectedMedian, foundMedian,0);
    }
}
