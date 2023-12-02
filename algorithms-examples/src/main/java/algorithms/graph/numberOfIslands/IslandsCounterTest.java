package algorithms.graph.numberOfIslands;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IslandsCounterTest {

    @Test
    public void testCountIslandsDFS1WithAdditionalMatrix() {
        testCountIslandsInternal(new IslandCounterDFS1AdditionalMatrix());
    }

    @Test
    public void testCountIslandsDFS2WithoutAdditionalMatrix() {
        testCountIslandsInternal(new IslandCounterDFS2WithoutAdditionalMatrix());
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
        assertEquals("num of islands not as expected", 6, numOfIslandsFound);
    }
}
