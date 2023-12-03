package algorithms.graph.numberOfIslands;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IslandsCounterTest {

    @Test
    public void testCountIslands_1_DFSWithAdditionalMatrix() {
        IslandsCounter islandsCounter = new IslandCounter_1_DFSAdditionalMatrix();
        testCountIslandsInternal(islandsCounter);
    }

    @Test
    public void testCountIslands_2_DFSWithoutAdditionalMatrix() {
        IslandsCounter islandsCounter = new IslandCounter_2_DFSWithoutAdditionalMatrix();
        testCountIslandsInternal(islandsCounter);
    }

    private void testCountIslandsInternal(IslandsCounter islandsCounter) {
        int matrix[][] = new int[][] {
                { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 }
        };

        int numOfIslandsFound = islandsCounter.countIslands(matrix);
        int numOfIslandsExpected = 5;
        assertEquals("num of islands not as expected", numOfIslandsExpected, numOfIslandsFound);
    }
}
