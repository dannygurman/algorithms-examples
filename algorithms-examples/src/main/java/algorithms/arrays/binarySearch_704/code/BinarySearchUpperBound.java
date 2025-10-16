package algorithms.arrays.binarySearch_704.code;

public class BinarySearchUpperBound {

    /**
     * Public method — returns the rightmost index of target if found,
     * otherwise returns -1.
     */
    public int searchExact(int[] nums, int target) {
        int insertionPoint = findUpperBound(nums, target);

        // If target exists, it's just before the insertion point.
        if (insertionPoint > 0 && nums[insertionPoint - 1] == target) {
            return insertionPoint - 1;
        } else {
            return -1;
        }
    }

    /**
     * Public method — always returns the insertion index (upper bound),
     * even if target is not found.
     */
    public int searchInsert(int[] nums, int target) {
        return findUpperBound(nums, target);
    }

    /**
     * Private internal helper that finds the first index
     * greater than target (the upper bound).
     */
    private int findUpperBound(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) { //Not <=
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left; // first index when > target
    }
}