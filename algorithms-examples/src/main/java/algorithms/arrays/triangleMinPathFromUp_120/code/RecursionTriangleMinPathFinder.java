package algorithms.arrays.triangleMinPathFromUp_120.code;


import java.util.List;


class RecursionTriangleMinPathFinder implements TriangleMinPathFinder {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] memo = new Integer[n][n]; // Memoization table
        return findMinPathRec(triangle, 0, 0, memo);
    }

    private int findMinPathRec(List<List<Integer>> triangle, int row, int col, Integer[][] memo) {
        // Base case: If we are at the last row
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }

        // Memoization check: If already computed
        if (memo[row][col] != null) {
            return memo[row][col];
        }

        // Recursive step
        int currentValue = triangle.get(row).get(col);
        int path1 = findMinPathRec(triangle, row + 1, col, memo);
        int path2 = findMinPathRec(triangle, row + 1, col + 1, memo);

        int minPath = currentValue + Math.min(path1, path2);

        // Store result in memo and return
        memo[row][col] = minPath;

        return minPath;
    }
}

