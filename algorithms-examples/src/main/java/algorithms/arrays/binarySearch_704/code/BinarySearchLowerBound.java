package algorithms.arrays.binarySearch_704.code;

public class BinarySearchLowerBound {

    /**
     * Public method — returns the leftmost index of target if found,
     * otherwise returns -1.
     */
    public int searchExact(int[] nums, int target) {
        int insertionPoint = findLowerBound(nums, target);

        // If target exists, it must be at insertionPoint
        if (insertionPoint < nums.length && nums[insertionPoint] == target) {
            return insertionPoint;
        } else {
            return -1;
        }
    }

    /**
     * Public method — always returns the insertion index (lower bound),
     * even if target is not found.
     */
    public int searchInsert(int[] nums, int target) {
        return findLowerBound(nums, target);
    }

    /**
     * Private internal helper that finds the first index
     * where nums[index] >= target (the lower bound).
     */
    private int findLowerBound(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) { //NOTE < not <=
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left; // first index when >= target
    }
}