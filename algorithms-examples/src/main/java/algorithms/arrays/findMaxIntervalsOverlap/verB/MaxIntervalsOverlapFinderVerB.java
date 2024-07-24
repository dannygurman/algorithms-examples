package algorithms.arrays.findMaxIntervalsOverlap.verB;

import algorithms.arrays.findMaxIntervalsOverlap.MaxIntervalsOverlapFinder;

import java.util.Arrays;

/**
 * Time Complexity: O(nLogn).
 * Auxiliary Space: O(1) as no extra space has been taken
 */
public class MaxIntervalsOverlapFinderVerB implements MaxIntervalsOverlapFinder {

    @Override
    public int findMaxGuests(int[] arriveTimes, int[] exitTimes) {

        // Sort arrival and exit arrays
        Arrays.sort(arriveTimes);
        Arrays.sort(exitTimes);

        int arrivalsNum = arriveTimes.length; //assumption arriveTimes.length = exitTimes.length

        // guests_in indicates number of guests at a time
        int guests_in = 1;
        int max_guests = 1;
        int time = arriveTimes[0];

        //starting from first arrival - 1 guest
        int arriveTimesIndex = 1;
        int exitTimesIndex = 0;

        // Similar to merge in merge sort to process all events in sorted order

        while (arriveTimesIndex < arrivalsNum &&  exitTimesIndex < arrivalsNum) {

           // If next event in sorted order is arrival, increment count of guests
            int nextArrivalTime = arriveTimes[arriveTimesIndex];
            int nextExitTime = arriveTimes[arriveTimesIndex];

            if (nextArrivalTime <= nextExitTime){
                guests_in++;

                // Update max_guests if needed
                if (guests_in > max_guests) {
                    max_guests = guests_in;
                    time = nextArrivalTime;
                }
                arriveTimesIndex++; //increment index of arrival array
            }
            else {
            //If next event in sorted order is exit, decrement count of guests.
                guests_in--;
                exitTimesIndex++;
            }
        }

        System.out.println("Maximum Number of Guests = " + max_guests + " at time " + time);
        return max_guests;
    }

}

