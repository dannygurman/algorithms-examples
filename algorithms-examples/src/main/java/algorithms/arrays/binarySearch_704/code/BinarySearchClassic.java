package algorithms.arrays.binarySearch_704.code;

public class BinarySearchClassic {

    //return the index.
    //If target does not exist return -1
    //Assumption: nums is sorted
    //If duplicates - return any index
    public int search(int[] nums, int target) {
        // Set the left and right boundaries
        int left = 0, right = nums.length - 1;

        // Under this condition
        while (left <= right) {
            // Get the middle index and the middle value.
            int mid = left + (right - left) / 2;

            // Case 1, return the middle index.
            if (nums[mid] == target) {
                return mid;
            }
            // Case 2, discard the smaller half.
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            // Case 3, discard the larger half.
            else {
                right = mid - 1;
            }
        }

        // If we finish the search without finding target, return -1.
        return -1;
    }
}