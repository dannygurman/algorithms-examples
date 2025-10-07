package algorithms.arrays.triangleMinPathFromUp_120.code;

import java.util.List;

class DpBottomUpTriangleMinPathFinder implements TriangleMinPathFinder {

    /**
     * Finds the minimum path sum from top to bottom of a triangle.
     * Uses Bottom-Up dynamic programming (DP) with space optimization.
     *
     * @param triangle List of lists representing the triangle
     * @return The minimum path sum from top to bottom
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        // Get the height of the triangle
        int triangleHeight = triangle.size();

        // Initialize DP array with size (height + 1)
        // The extra space allows us to avoid boundary checks
        int[] minPathSum = new int[triangleHeight + 1];

        // Process the triangle from bottom to top
        for (int row = triangleHeight - 1; row >= 0; row--) {
            // For each position in the current row
            for (int col = 0; col <= row; col++) {
                // Calculate minimum path sum for current position
                // Choose the minimum between the two adjacent positions below
                // and add the current element's value
                minPathSum[col] = Math.min(minPathSum[col], minPathSum[col + 1])
                        + triangle.get(row).get(col);
            }
        }

        // The minimum path sum from top to bottom is stored at index 0
        return minPathSum[0];
    }
}
