package algorithms.graph.numberOfIslands;

/**
 * Time complexity:
 * O(ROW x COL), where ROW is the number of rows and COL is the number of columns in the given matrix.
 * Auxiliary Space:
 * O(ROW x COL), for creating an additional visited matrix.
 */
public class IslandCounter_1_DFSAdditionalMatrix implements IslandsCounter {

    // These arrays are used to get row and column numbers of 8 neighbors of a given cell
    private final static int ROW_NEIGHBOURS[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    private final static int COLUMN_NEIGHBOURS[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

    // The main function that returns count of islands in a given boolean 2D matrix
    @Override
    public int countIslands(int[][] matrix) {

        int rowCount = matrix.length;
        //assumption - all rows - has same num of column + there is at least 1 row
        int columnsCount = matrix[0].length;


        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
        boolean visited[][] = new boolean[rowCount][columnsCount];

        // Initialize count as 0 and traverse through the  all cells of given matrix
        int count = 0;
        for (int i = 0; i < rowCount; ++i) {
            for (int j = 0; j < columnsCount; ++j) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    // If a cell with value 1 is not visited yet, then new island found,
                    // Visit all cells on this island and increment island count
                    DFS(matrix, i, j, visited, rowCount, columnsCount);
                    count++;
                }
            }
        }

        return count;
    }

    // A utility function to do DFS for a 2D boolean matrix.
    // It only considers the 8 neighbors as adjacent vertices
    private void DFS(int matrix[][], int row, int col,
                     boolean visited[][],
                     final int rowCount, final int columnsCount) {

        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k) {
            int rowNeighbour = row + ROW_NEIGHBOURS[k];
            int columnNeighbour = col + COLUMN_NEIGHBOURS[k];

            boolean shouldBeIncludedInDFS = shouldBeIncludedInDF(matrix,
                    rowNeighbour,
                    columnNeighbour,
                    visited,
                    rowCount,
                    columnsCount);

            if (shouldBeIncludedInDFS) {
                DFS(matrix,
                        rowNeighbour,
                        columnNeighbour,
                        visited,
                        rowCount,
                        columnsCount);
            }
        }
    }


    // A function to check if a given cell (row, col) can be included in DFS
    private boolean shouldBeIncludedInDF(int matrix[][], final int rowId, final int colId,
                                         boolean visited[][], final int rowCount, final int columnsCount) {
        // row number is in range, column number is in range and value is 1 and not yet visited
        return (rowId >= 0)
                && (rowId < rowCount)
                && (colId >= 0)
                && (colId < columnsCount)
                && (matrix[rowId][colId] == 1
                && !visited[rowId][colId]);
    }


}
