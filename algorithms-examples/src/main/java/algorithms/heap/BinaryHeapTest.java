package algorithms.heap;

import algorithms.utils.AlgorithmUtils;
import org.junit.Assert;
import org.junit.Test;

public class BinaryHeapTest {

    @Test
    public void test_buildHeapBinaryTree(){
        int array[] = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
        int [] expectedHeapRepresentingArray = {17, 15, 13, 9, 6, 5, 10, 4, 8, 3, 1};

        //Modifying array to represent max heap
        BinaryHeapUtils.buildMaxHeap(array);

        AlgorithmUtils.printArray(array);

        Assert.assertArrayEquals("Array not representing heap as expected", expectedHeapRepresentingArray, array);

    }


    @Test
    public void test_HeapSort(){
        int array[] = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
        int [] expectedSortedArray = {1, 3, 4, 5, 6, 8, 9, 10, 13, 15, 17};

        //Sorting array
        BinaryHeapUtils.heapsort(array);

        AlgorithmUtils.printArray(array);

        Assert.assertArrayEquals("Array not sorted as expected", expectedSortedArray, array);

    }
}
