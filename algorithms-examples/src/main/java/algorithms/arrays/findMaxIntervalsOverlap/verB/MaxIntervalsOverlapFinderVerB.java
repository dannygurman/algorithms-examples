package algorithms.arrays.findMaxIntervalsOverlap.verB;

import algorithms.arrays.findMaxIntervalsOverlap.MaxIntervalsOverlapFinder;

import java.util.Arrays;

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
        int arriveTimesIndex = 1;
        int exitTimesIndex = 0;

        // Similar to merge in merge sort to process all events in sorted order

        while (arriveTimesIndex < arrivalsNum &&  exitTimesIndex < arrivalsNum) {

           // If next event in sorted order is arrival, increment count of guests
            if (arriveTimes[arriveTimesIndex] <= exitTimes[exitTimesIndex]){
                guests_in++;

                // Update max_guests if needed
                if (guests_in > max_guests) {
                    max_guests = guests_in;
                    time = arriveTimes[arriveTimesIndex];
                }
                arriveTimesIndex++; //increment index of arrival array
            }
            else {
            // If event is exit, decrement count of guests.
                guests_in--;
                exitTimesIndex++;
            }
        }

        System.out.println("Maximum Number of Guests = " + max_guests + " at time " + time);
        return max_guests;
    }

}


   /*     // guests_in indicates number of guests at a time
        int guests_in = 1, max_guests = 1, time = arrl[0];
        int i = 1, j = 0;

        // Similar to merge in merge sort to process
        // all events in sorted order
        while (i < n && j < n)
        {
        // If next event in sorted order is arrival,
        // increment count of guests
        if (arrl[i] <= exit[j])
        {
        guests_in++;

        // Update max_guests if needed
        if (guests_in > max_guests)
        {
        max_guests = guests_in;
        time = arrl[i];
        }
        i++; //increment index of arrival array
        }
        else // If event is exit, decrement count
        { // of guests.
        guests_in--;
        j++;
        }
        }*/