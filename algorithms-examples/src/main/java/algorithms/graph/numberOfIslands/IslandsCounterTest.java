package algorithms.graph.numberOfIslands;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IslandsCounterTest {

    @Test
    public void testCountIslandsDFS1WithAdditionalMatrix() {
        IslandsCounter islandsCounter = new IslandCounterDFS1AdditionalMatrix();
        testCountIslandsInternal(islandsCounter);
    }

    @Test
    public void testCountIslandsDFS2WithoutAdditionalMatrix() {
        IslandsCounter islandsCounter = new IslandCounterDFS2WithoutAdditionalMatrix();
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
