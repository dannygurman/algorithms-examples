package algorithms.arrays.closestValueToValUnsortedArray;

public class ClosestToValInUnsortedFinder {

    public int findClosestToValInUnsortedArray(int arr[], int val){
        // Stores the closest value to val
        int res = arr[0];


        for(int i = 1; i < arr.length; i++)  {
            // If absolute difference of val and res exceeds
            // absolute difference of val  and current element
            if (Math.abs(val - res) >  Math.abs(val - arr[i])) {
                res = arr[i];
            }
        }

        // Return the closest array element
        return res;

    }
}
