package algorithms.arrays.closestValueToKUnsortedArray;

public class ClosestToKInUnsortedFinder {

    public int findClosestToKInUnsortedArray(int arr[], int k){
        // Stores the closest value to K
        int res = arr[0];


        for(int i = 1; i < arr.length; i++)  {

            // If absolute difference f K and res exceeds
            // absolute difference of K  and current element
            if (Math.abs(k - res) >  Math.abs(k - arr[i]))
            {
                res = arr[i];
            }
        }

        // Return the closest
        // array element
        return res;

    }
}
