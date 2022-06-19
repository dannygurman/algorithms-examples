package algorithms.heap;

import algorithms.utils.AlgorithmUtils;

public class BinaryHeapUtils {

    // Function to build a Max-Heap from the Array
    public static void buildMaxHeap(int arr[]) {

        // Index of last non-leaf node
        int startIndex = getLastNonLeafNodeIndex(arr);

        // Perform reverse level order traversal
        // from last non-leaf node and heapify
        // each node
        for (int i = startIndex; i >= 0; i--) {
            heapifyMax(arr, arr.length, i);
        }
    }


    public static void heapsort(int arr[]){
     //First build maxHeap
        buildMaxHeap(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
          //Swapping root(first node) with current last element(evert time left array to be sorted is shorter)
            AlgorithmUtils.swap(arr, 0, i);

            // Heapify root element - lengthToHeapify set to i , everytime we heapify smaller tree
            heapifyMax(arr, i, 0);
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

    /**
     *  Heapify to build Max heap
     *  lengthToHeapify could be less then  arr.length (for sort algorithm) -
     *  in this cse we ignore array members in indexes above lengthToHeapify
     * */

    //I length
    private static void heapifyMax(int arr[],int lengthToHeapify, int rootIndex) {
        int largestIndex = rootIndex; // Initialize largest as root

        int leftIndex = getLeftChildIndex(rootIndex); // left = 2*i + 1
        int rightIndex = getRightChildIndex(rootIndex); // right = 2*i + 2


        // If left child is larger than root
        if (leftIndex < lengthToHeapify && arr[leftIndex] > arr[largestIndex]) {
            largestIndex = leftIndex;
        }

        // If right child is larger than largest so far
        if (rightIndex < lengthToHeapify && arr[rightIndex] > arr[largestIndex]) {
            largestIndex = rightIndex;
        }

        // If largest is not root
        if (largestIndex != rootIndex) {
            //Swap root and largest values - so  root index will contain largest value
            AlgorithmUtils.swap(arr, rootIndex, largestIndex);

            // Recursively heapify the affected sub-tree
            heapifyMax(arr, lengthToHeapify, largestIndex);
        }
    }


}
