package algorithms.arrays.medianOfTwoSortedArray.mergingExtraSpace;

import algorithms.arrays.medianOfTwoSortedArray.TwoSortedArrayMedianFinder;

public class TwoSortedArrayMedianFinder_MergingWithExtraSpace implements TwoSortedArrayMedianFinder {

    @Override
    public double getSortedArraysMedian(int[] A, int[] B) {
        //Arrays sizes are equal
       int n = A.length;
       int [] mergedArray = new int [2*n];
       int indexA = 0, indexB =0, indexMerged = 0;
       while (indexA < n && indexB < n) {
           if (A[indexA] <= B[indexB]){
               mergedArray[indexMerged] = A[indexA];
               indexA++;
           } else {
               mergedArray[indexMerged] = B[indexB];
               indexB++;
           }
           indexMerged++;
       }

       while (indexA < n){
           mergedArray[indexMerged] = A[indexA];
           indexA++;
           indexMerged++;
       }

        while (indexB < n){
            mergedArray[indexMerged] = B[indexB];
            indexB++;
            indexMerged++;
        }

       return (double) ((mergedArray[n-1] + mergedArray[n])) / 2;

    }
}
