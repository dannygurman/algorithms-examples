package algorithms.arrays.closestValueToValUnsortedArray;

import org.junit.Assert;
import org.junit.Test;

public class ClosestToValInUnsortedFinderTest {

    @Test
    public void testClosestToValInUnsortedFinder(){
        int arr[] = { 100, 200, 400 };
        int k = 300;

        ClosestToValInUnsortedFinder finder = new ClosestToValInUnsortedFinder();
        int foundVal = finder.findClosestToValInUnsortedArray(arr, k);
        Assert.assertEquals("not as expected", 200, foundVal);
    }
}
