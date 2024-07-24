package algorithms.arrays.findMaxIntervalsOverlap.verC;

import algorithms.arrays.findMaxIntervalsOverlap.MaxIntervalsOverlapFinder;

import java.util.Arrays;

public class MaxIntervalsOverlapFinderVerC implements MaxIntervalsOverlapFinder {

    @Override
    public int findMaxGuests(int[] arriveTimes, int[] exitTimes) {

        int arrivalsCount = arriveTimes.length; //assumption arriveTimes.length = exitTimes.length

        // Finding maximum starting time
        int maxArrivalsTimeHour = Arrays.stream(arriveTimes).max().getAsInt();

        // Finding maximum ending time
        int maxExitTimeHour = Arrays.stream(exitTimes).max().getAsInt();

        int maxTimeHour = Math.max(maxArrivalsTimeHour,maxExitTimeHour);

        int []auxilaryArray = new int[maxTimeHour + 2];
        Arrays.fill(auxilaryArray, 0);

        int cur=0;
        int idx=0;

        // Creating an auxiliary array
        for(int i = 0; i < arrivalsCount; i++)
        {
            // Lazy addition
            ++auxilaryArray[arriveTimes[i]];
            --auxilaryArray[exitTimes[i]+1];
        }

        int maxy=Integer.MIN_VALUE;

        //Lazily Calculating value at index i
        for(int i = 0; i <= maxTimeHour; i++)
        {
            cur+=auxilaryArray[i];
            if(maxy < cur)
            {
                maxy = cur;
                idx = i;

            }
        }
        System.out.println("Maximum value is:"+ maxy+" at position: "+idx+"");
        return maxy;
    }
}
