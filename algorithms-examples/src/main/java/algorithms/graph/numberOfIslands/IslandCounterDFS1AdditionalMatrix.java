package algorithms.graph.numberOfIslands;

public class IslandCounterDFS1AdditionalMatrix implements IslandsCounter {

    @Override
    public int countIslands(int[][] matrix) {

        int rowCount = matrix.length;
        int columnsCount = matrix[0].length ;//assumption - all rows - has same num of column + there is at least 1 row


        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
        boolean visited[][] = new boolean[rowCount][columnsCount];

        // Initialize count as 0 and traverse through the  all cells of given matrix
        int count = 0;
        for (int i = 0; i < rowCount; ++i)
            for (int j = 0; j < columnsCount; ++j)
                if (matrix[i][j] == 1  && !visited[i][j]){
                    // If a cell with value 1 is not visited yet, then new island found,
                    // Visit all cells in this island and increment island count
                    DFS(matrix, i, j, visited);
                    count++;
                }

        return count;
    }



    // A function to check if a given cell (row, col) can
    // be included in DFS
    boolean isSafe(int matrix [][], final int rowId, final int colId,
                   boolean visited[][], final int rowCount, final int columnsCount)
    {
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (rowId >= 0) && (row < ROW) && (col >= 0)
                && (col < COL)
                && (M[row][col] == 1 && !visited[row][col]);
    }

    // A utility function to do DFS for a 2D boolean matrix.
    // It only considers the 8 neighbors as adjacent
    // vertices
    void DFS(int M[][], int row, int col,
             boolean visited[][])
    {
        // These arrays are used to get row and column
        // numbers of 8 neighbors of a given cell
        int rowNbr[]
                = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
        int colNbr[]
                = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k],
                    visited))
                DFS(M, row + rowNbr[k], col + colNbr[k],
                        visited);
    }

    // The main function that returns count of islands in a
    // given boolean 2D matrix

}
