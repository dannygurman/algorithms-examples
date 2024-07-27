package algorithms.arrays.findArraySecondLargestElement;

import java.util.Arrays;

/**
 * TWO PASS
 */
public class SecondLargestFinderByTraversingArrayTwice implements SecondLargestFinder {


    @Override
    public Integer findSecondLargest(final Integer[] numbers) {

        // There should be atleast two elements
        if (numbers.length < 2) {
            System.out.printf(" Invalid Input ");
            return null;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // Find the largest element
        for (int i = 0; i < numbers.length; i++) {
            largest = Math.max(largest, numbers[i]);
        }

        //Another option:
        //largest = Arrays.stream(numbers)
        // .max(Integer::compare)
        // .orElseThrow(RuntimeException::new);

        // Find the second-largest element
        for (int i = 0; i < numbers.length; i++) {
            int currentValue = numbers[i];
            if (currentValue == largest) {
                continue; //skip if largest
            }
            //check if large then current second
            secondLargest = Math.max(secondLargest, numbers[i]);
        }


        if (secondLargest == Integer.MIN_VALUE) {
            System.out.printf("There is no second largest element\n");
            return null;
        }

        return secondLargest;
    }
}
