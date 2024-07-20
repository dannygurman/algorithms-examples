package algorithms.arrays.closestValueToKUnsortedArray;

import org.junit.Assert;
import org.junit.Test;

public class ClosestToKInUnsortedFinderTest {

    @Test
    public void testClosestToKInUnsortedFinder(){
        int arr[] = { 100, 200, 400 };
        int k = 300;

        ClosestToKInUnsortedFinder finder = new ClosestToKInUnsortedFinder();
        int foundVal = finder.findClosestToKInUnsortedArray(arr, k);
        Assert.assertEquals("not as expected", 200, foundVal);
    }
}
