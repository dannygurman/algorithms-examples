package algorithms.arrays.closestValueToValUnsortedArray;

public class ClosestToValInUnsortedFinder {

    public int findClosestToValInUnsortedArray(int arr[], int val){
        // Stores the closest value to val
        int closestValue = arr[0];


        for(int i = 1; i < arr.length; i++)  {
            // If absolute difference of val and res exceeds
            // absolute difference of val  and current element
            int curVal = arr[i];
            if (Math.abs(val - closestValue) >  Math.abs(val - curVal)) {
                closestValue = curVal;
            }
        }

        // Return the closest array element
        return closestValue;

    }
}
