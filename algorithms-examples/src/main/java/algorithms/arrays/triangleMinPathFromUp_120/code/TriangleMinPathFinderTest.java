package algorithms.arrays.triangleMinPathFromUp_120.code;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TriangleMinPathFinderTest {

    @Test
    public void tesRecursionTriangleMinPathFinder() {
        TriangleMinPathFinder recursionTriangleMinPathFinder = new RecursionTriangleMinPathFinder();
        verifyTriangleMinPathFinderInternal(recursionTriangleMinPathFinder);
    }

    @Test
    public void tesDpBottomUpTriangleMinPathFinder() {
        TriangleMinPathFinder dpBottomUpTriangleMinPathFinder = new DpBottomUpTriangleMinPathFinder();
        verifyTriangleMinPathFinderInternal(dpBottomUpTriangleMinPathFinder);
    }

    private void verifyTriangleMinPathFinderInternal(TriangleMinPathFinder triangleMinPathFinder) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(2));
        triangle.add(List.of(3, 4));
        triangle.add(List.of(6, 5, 7));
        triangle.add(List.of(4, 1, 8, 3));

        int foundMinPathSum = triangleMinPathFinder.minimumTotal(triangle);
        Assert.assertEquals(11, foundMinPathSum);
    }

}
