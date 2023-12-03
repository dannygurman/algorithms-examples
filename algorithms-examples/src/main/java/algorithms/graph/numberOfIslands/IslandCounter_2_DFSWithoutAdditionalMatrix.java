package algorithms.graph.numberOfIslands;

/**
 * // Java Program to count islands in boolean 2D matrix
 * The idea is to modify the given matrix, and perform DFS to find the total number of islands
 * Time complexity:
 * O(ROW x COL), where ROW is the number of rows and COL is the number of columns in the given matrix.
 * Auxiliary Space:
 * O(ROW * COL), as to do DFS we need extra auxiliary stack space (cause of recursion).
 * Using Extra O(n*m) Space:
 */
public class IslandCounter_2_DFSWithoutAdditionalMatrix implements IslandsCounter {


    @Override
    public int countIslands(int[][] matrix) {
        int rowCount = matrix.length;
        //assumption - all rows - has same num of column + there is at least 1 row
        int columnsCount = matrix[0].length;

        int count = 0;
        for (int rowId = 0; rowId < rowCount; rowId++) {
            for (int columnId = 0; columnId < columnsCount; columnId++) {
                if (matrix[rowId][columnId] == 1) {
                    count++;
                    // traversal starts from current cell
                    DFS(matrix, rowId, columnId, rowCount, columnsCount);
                }
            }
        }
        return count;
    }


    // A utility function to do DFS for a 2D
    // boolean matrix. It only considers
    // the 8 neighbours as adjacent vertices
    static void DFS(int[][] matrix, int rowId, int columnId, int rowCount, int columnCount) {

        // Base condition
        // if i less than 0 or j less than 0 or i greater
        // than ROW-1 or j greater than COL- or if M[i][j]
        // != 1 then we will simply return
        if (rowId < 0
                || columnId < 0
                || rowId > (rowCount - 1)
                || columnId > (columnCount - 1)
                || matrix[rowId][columnId] != 1) {
            return;
        }

         if (matrix[rowId][columnId] == 1) {
             //marking as 0 !
            matrix[rowId][columnId] = 0;
            DFS(matrix, rowId + 1, columnId, rowCount, columnCount); // right side traversal
            DFS(matrix, rowId - 1, columnId, rowCount, columnCount); // left side traversal
            DFS(matrix, rowId, columnId + 1, rowCount, columnCount); // upward side traversal
            DFS(matrix, rowId, columnId - 1, rowCount, columnCount); // downward side traversal
            DFS(matrix, rowId + 1, columnId + 1, rowCount, columnCount); // upward-right side traversal
            DFS(matrix, rowId - 1, columnId - 1, rowCount, columnCount); // downward-left side traversal
            DFS(matrix, rowId + 1, columnId - 1, rowCount, columnCount); // downward-right side traversal
            DFS(matrix, rowId - 1, columnId + 1, rowCount, columnCount); // upward-left side traversal
        }
    }

}



