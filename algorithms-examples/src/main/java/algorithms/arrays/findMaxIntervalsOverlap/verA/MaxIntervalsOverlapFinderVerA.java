package algorithms.arrays.findMaxIntervalsOverlap.verA;

import algorithms.arrays.findMaxIntervalsOverlap.MaxIntervalsOverlapFinder;

import java.util.Arrays;

public class MaxIntervalsOverlapFinderVerA  implements MaxIntervalsOverlapFinder {


    @Override
    public int findMaxGuests(int[] arriveTimes, int[] exitTimes) {
        int minTime = Arrays.stream(arriveTimes).min().getAsInt();
        int maxTime = Arrays.stream(exitTimes).max().getAsInt();

        //The count array hold the number of guests in each hour
        //in
        int countArraySize = maxTime - minTime + 1;
        int [] countArray = new int[countArraySize];

        int arrivalsNum = arriveTimes.length; //assumption arriveTimes.length = exitTimes.length

        for (int i =0 ; i <= arrivalsNum -1 ; i++) {
            int arrival = arriveTimes[i];
            int exit = exitTimes[i];

            for (int j = arrival ;j <= exit ; j++){
                countArray[ j - minTime]++;
            }
        }


        return 0;

    }
}
