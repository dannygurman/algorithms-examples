package algorithms.arrays.binarySearch_704.code;

public class BinarySearchLowerBound {

    public int search(int[] nums, int target) {
        // Set the left and right boundaries
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (left < nums.length && nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }
}
