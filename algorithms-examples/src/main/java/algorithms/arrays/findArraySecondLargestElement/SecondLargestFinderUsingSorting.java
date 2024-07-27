package algorithms.arrays.findArraySecondLargestElement;

import java.util.Arrays;
import java.util.Collections;

public class SecondLargestFinderUsingSorting implements SecondLargestFinder {
    @Override
    public Integer findSecondLargest(Integer []  numbers) {
        // Sort the array in descending order
        Arrays.sort(numbers, Collections.reverseOrder());

        int firstElement = numbers[0];
        // Start from second element as first element is the largest
        for (int i = 1; i < numbers.length; i++) {
            int currentNum = numbers[i];
            // If the element is not  equal to largest element
            if (currentNum != firstElement) {
             return currentNum;
            }
        }
        //second not found (all values are the same)- return null
        return null;
    }
}
