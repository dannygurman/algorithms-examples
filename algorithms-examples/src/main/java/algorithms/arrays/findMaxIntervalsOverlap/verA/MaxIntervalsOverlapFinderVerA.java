package algorithms.arrays.findMaxIntervalsOverlap.verA;

import algorithms.arrays.findMaxIntervalsOverlap.MaxIntervalsOverlapFinder;

import java.util.Arrays;

/**
 * Above solution requires O(max-min+1) extra space
 * . Also time complexity of  solution depends on lengths of intervals.
 * In worst case, if all intervals are from ‘min’ to ‘max’, then time complexity
 * becomes O((max-min+1)*n) where n is number of intervals.
 */
public class MaxIntervalsOverlapFinderVerA  implements MaxIntervalsOverlapFinder {


    @Override
    public int findMaxGuests(int[] arriveTimes, int[] exitTimes) {
        int minTimeHour = Arrays.stream(arriveTimes).min().getAsInt();
        int maxTimeHour = Arrays.stream(exitTimes).max().getAsInt();

        //The count array hold the number of guests in each hour
        //The indexes are the hours (starting from minTimeHour) and the values - the num of guests
        int countArraySize = maxTimeHour - minTimeHour + 1;
        int [] guestsPerHourCount = new int[countArraySize];

        int arrivalsCount = arriveTimes.length; //assumption arriveTimes.length = exitTimes.length

        for (int i =0 ; i <= arrivalsCount -1 ; i++) {
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
