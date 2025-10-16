package algorithms.arrays.binarySearch_704.code;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for verifying various binary search implementations:
 * - Classic binary search (exact match only)
 * - Lower bound (leftmost match or insertion position)
 * - Upper bound (rightmost match or insertion position)
 *
 * The test array contains multiple duplicates of the value 9 to validate
 * both lower and upper bound behavior.
 */
public class BinarySearchTest {

    // Test data: sorted array with duplicates of 9 (indices 3–9)
    int[] nums = {1, 2, 3, 9, 9, 9, 9, 9, 9, 9, 13, 14};
    int foundIndex = -1;

    /**
     * Tests the classic binary search implementation that returns
     * an arbitrary matching index (in this case, middle 9 at index 5),
     * or -1 if the element is not found.
     */
    @Test
    public void testBinarySearchClassic() {
        BinarySearchClassic binarySearchClassic = new BinarySearchClassic();

        // Expect middle occurrence of 9 (any valid found index is acceptable)
        foundIndex = binarySearchClassic.search(nums, 9);
        Assert.assertEquals(5, foundIndex);

        // 10 does not exist in array
        foundIndex = binarySearchClassic.search(nums, 10);
        Assert.assertEquals(-1, foundIndex);
    }

    /**
     * Tests lower bound (leftmost match) using searchExact().
     * - Returns the first index where target exists.
     * - Returns -1 if target is not present.
     */
    @Test
    public void testBinarySearchLowerBound_SearchExact() {
        BinarySearchLowerBound binarySearchLowerBound = new BinarySearchLowerBound();

        // First 9 is at index 3
        foundIndex = binarySearchLowerBound.searchExact(nums, 9);
        Assert.assertEquals(3, foundIndex);

        // 10 not present
        foundIndex = binarySearchLowerBound.searchExact(nums, 10);
        Assert.assertEquals(-1, foundIndex);
    }

    /**
     * Tests lower bound insertion logic using searchInsert().
     * - Returns index where target should be inserted (first element >= target).
     */
    @Test
    public void testBinarySearchLowerBound_SearchInsert() {
        BinarySearchLowerBound binarySearchLowerBound = new BinarySearchLowerBound();

        // For 9 → insert before first 9 (index 3)
        foundIndex = binarySearchLowerBound.searchInsert(nums, 9);
        Assert.assertEquals(3, foundIndex);

        // For 4 → first element >= 4 is 9 at index 3
        foundIndex = binarySearchLowerBound.searchInsert(nums, 4);
        Assert.assertEquals(3, foundIndex);

        // For 10 → first element >= 10 is 13 at index 10
        foundIndex = binarySearchLowerBound.searchInsert(nums, 10);
        Assert.assertEquals(10, foundIndex);
    }

    /**
     * Tests upper bound (rightmost match) using searchExact().
     * - Returns the last index where target exists.
     * - Returns -1 if target is not present.
     */
    @Test
    public void testBinarySearchUpperBound_SearchExact() {
        BinarySearchUpperBound bs = new BinarySearchUpperBound();

        // Rightmost 9 is at index 9 (range of 9s: 3..9)
        int foundIndex = bs.searchExact(nums, 9);
        Assert.assertEquals(9, foundIndex);

        // 10 not present
        foundIndex = bs.searchExact(nums, 10);
        Assert.assertEquals(-1, foundIndex);

        // Single occurrence of 1 → rightmost is itself (index 0)
        foundIndex = bs.searchExact(nums, 1);
        Assert.assertEquals(0, foundIndex);

        // Last element 14 → index 11
        foundIndex = bs.searchExact(nums, 14);
        Assert.assertEquals(11, foundIndex);
    }

    /**
     * Tests upper bound insertion logic using searchInsert().
     * - Returns index of first element greater than target (insertion point after duplicates).
     */
    @Test
    public void testBinarySearchUpperBound_SearchInsert() {
        BinarySearchUpperBound bs = new BinarySearchUpperBound();

        // For 9 → insert after all 9s → next element is 13 at index 10
        foundIndex = bs.searchInsert(nums, 9);
        Assert.assertEquals(10, foundIndex);

        // For 10 → not found; next greater element (13) is at index 10
        foundIndex = bs.searchInsert(nums, 10);
        Assert.assertEquals(10, foundIndex);

        // For 4 → first element greater than 4 is 9 at index 3
        foundIndex = bs.searchInsert(nums, 4);
        Assert.assertEquals(3, foundIndex);

        // For 0 → insert before all elements (start)
        foundIndex = bs.searchInsert(nums, 0);
        Assert.assertEquals(0, foundIndex);

        // For 20 → insert after all elements (end, index = array length)
        foundIndex = bs.searchInsert(nums, 20);
        Assert.assertEquals(12, foundIndex);
    }
}