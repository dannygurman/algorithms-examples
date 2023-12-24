package algorithms.arrays.medianOfTwoSortedArray.countingWhileMerging;

import algorithms.arrays.medianOfTwoSortedArray.TwoSortedArrayMedianFinder;

public class TwoSortedArrayMedianFinder_CountingWhileMerging implements TwoSortedArrayMedianFinder {
    @Override
    public double getSortedArraysMedian(int[] A, int[] B) {
        //Arrays sizes are equal
        int n = A.length;
        int indexA = 0, indexB = 0, count = 0;
        int middle1 = 0, middle2 = 0;

        while (count <= n) {

            middle1 = middle2;

            if (A[indexA] <= B[indexB]) {
                middle2 = A[indexA];
                indexA++;
            } else {
                middle2 = B[indexB];
                indexB++;
            }

            //All members in Array A are smaller than members in array B
            if (indexA == n) {
                middle1 = middle2;
                middle2 = B[0];
                break;
                //All members in Array B are smaller than members in array A
            } else if (indexB == n) {
                middle1 = middle2;
                middle2 = A[0];
                break;
            }

            count++;

        }
        return ((double)(middle1 + middle2) / 2);
    }
}
