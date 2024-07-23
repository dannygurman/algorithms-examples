package algorithms.arrays.findMaxIntervalsOverlap.verA;

import algorithms.arrays.findMaxIntervalsOverlap.MaxIntervalsOverlapFinder;

import java.util.Arrays;

public class MaxIntervalsOverlapFinderVerA  implements MaxIntervalsOverlapFinder {


    @Override
    public int findMaxGuests(int[] arriveTimes, int[] exitTimes) {
        int minTimeHour = Arrays.stream(arriveTimes).min().getAsInt();
        int maxTimeHour = Arrays.stream(exitTimes).max().getAsInt();

        //The count array hold the number of guests in each hour
        //The indexes are the hours (starting from minTimeHour) and the values - the num of guests
        int countArraySize = maxTimeHour - minTimeHour + 1;
        int [] guestsPerHourCount = new int[countArraySize];

        int arrivalsNum = arriveTimes.length; //assumption arriveTimes.length = exitTimes.length

        for (int i =0 ; i <= arrivalsNum -1 ; i++) {
            int arrival = arriveTimes[i];
            int exit = exitTimes[i];

            for (int j = arrival ;j <= exit ; j++){
                int countArrayIndex = j - minTimeHour;
                guestsPerHourCount[countArrayIndex]++;
            }
        }

       //return max guestsPerHourCount
        return Arrays.stream(guestsPerHourCount).max().getAsInt();
    }
}
