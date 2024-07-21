package algorithms.arrays.pairsTotalAmountDivisible;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountPairsDivisibleByNumFinder {

    private static int DIVIDER = 60;

    public static void main(String[] args)  {

        List <Integer> values = List.of(30, 20, 150, 100, 40);
        int numOfMatchingPairs = findNumPairsDivisibleBy60(values);
        System.out.println("numOfMatchingPairs:" + numOfMatchingPairs);
    }

    public static int findNumPairsDivisibleBy60(List<Integer> values) {
        int numOdMatchingPairs = 0;

        Map<Integer, Integer> reminderToCount = new HashMap<>();

        for (int value : values) {
            int valueReminder = value % DIVIDER;
            int oppositeReminder = DIVIDER - valueReminder;

            if ((valueReminder == 0) && (reminderToCount.containsKey(0))) {
                numOdMatchingPairs += reminderToCount.get(0);
            } else if (reminderToCount.containsKey(oppositeReminder)) {
                numOdMatchingPairs += reminderToCount.get(oppositeReminder);
            }

            int count = reminderToCount.getOrDefault(valueReminder, 0) + 1;
            reminderToCount.put(valueReminder, count );
            // OR - second working option
            //reminderToCount.merge(valueReminder, 1, (v1, v2) -> v1 + v2);
        }
        return numOdMatchingPairs;
    }

}