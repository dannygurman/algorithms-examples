package algorithms.heap;

import algorithms.utils.AlgorithmUtils;

public class HeapBuilder {

    // Function to build a Max-Heap from the Array
    public static void buildMaxHeap(int arr[]) {

        // Index of last non-leaf node
        int startIndex = getLastNonLeafNodeIndex(arr);

        // Perform reverse level order traversal
        // from last non-leaf node and heapify
        // each node
        for (int i = startIndex; i >= 0; i--) {
            heapifyMaxHeap(arr, i);
        }
    }

    private static int getLastNonLeafNodeIndex(int arr[]) {
        return ((arr.length / 2) - 1);
    }

    private static int getLeftChildIndex(int idx) {
        return (2 * idx + 1);
    }

    private static int getRightChildIndex(int idx) {
        return (2 * idx + 2);
    }


    private static void heapifyMaxHeap(int arr[], int rootIndex) {
        int largestIndex = rootIndex; // Initialize largest as root

        int leftIndex = getLeftChildIndex(rootIndex); // left = 2*i + 1
        int rightIndex = getRightChildIndex(rootIndex); // right = 2*i + 2
        int arraylength = arr.length;

        // If left child is larger than root
        if (leftIndex < arraylength && arr[leftIndex] > arr[largestIndex]) {
            largestIndex = leftIndex;
        }

        // If right child is larger than largest so far
        if (rightIndex < arraylength && arr[rightIndex] > arr[largestIndex]) {
            largestIndex = rightIndex;
        }

        // If largest is not root
        if (largestIndex != rootIndex) {
            //Swap root and largest values - so  root index will contain largest value
            AlgorithmUtils.swap(arr, rootIndex, largestIndex);

            // Recursively heapify the affected sub-tree
            heapifyMaxHeap(arr, largestIndex);
        }
    }


}
