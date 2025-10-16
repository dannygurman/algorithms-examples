package algorithms.arrays.binarySearch_704.code;

/**
 * Here we introduce an alternative way to implement binary search:
 * instead of looking for target in the array nums,
 * we look for the insert position where we can put target
 * in without disrupting the order.
 * In case of duplicates, we return the rightmost index.
 */
public class BinarySearchUpperBound {

    public int search(int[] nums, int target) {
        // Set the left and right boundaries
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (left > 0 && nums[left - 1] == target) {
            return left - 1;
        } else {
            return -1;
        }
    }
}