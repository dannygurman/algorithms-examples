package algorithms.arrays.binarySearch_704.code;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

    int[] nums = {1, 2, 3, 9, 9, 9, 9, 9, 9, 9, 10, 11};
    int target = 9;

    @Test
    public void testBinarySearchClassic() {
        BinarySearchClassic binarySearchClassic = new BinarySearchClassic();
        int foundIndex = binarySearchClassic.search(nums, target);
        Assert.assertEquals(5, foundIndex);
    }

    @Test
    public void testBinarySearchLowerBound() {
        BinarySearchLowerBound binarySearchLowerBound = new BinarySearchLowerBound();
        int foundIndex = binarySearchLowerBound.search(nums, target);
        Assert.assertEquals(3, foundIndex);
    }

    @Test
    public void testBinarySearchUpperBound() {
        BinarySearchUpperBound binarySearchUpperBound = new BinarySearchUpperBound();
        int foundIndex = binarySearchUpperBound.search(nums, target);
        Assert.assertEquals(9, foundIndex);
    }
}
