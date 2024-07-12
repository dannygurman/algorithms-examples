package algorithms.strings.numOfOccurence;

public class NumOfOccurrenceFinderNaive  implements NumOfOccurrenceFinder{

    @Override
    public int countOccurrences(int[] arr, int x) {
        int res = 0;
        for (int i = 0; i < arr.length; i++)
            if (x == arr[i]) {
                res++;
            }
        return res;
    }
}
