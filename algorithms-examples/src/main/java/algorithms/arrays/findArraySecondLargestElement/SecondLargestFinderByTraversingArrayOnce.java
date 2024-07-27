package algorithms.arrays.findArraySecondLargestElement;

public class SecondLargestFinderByTraversingArrayOnce implements SecondLargestFinder {
    @Override
    public Integer findSecondLargest(Integer[] numbers) {

        /* There should be atleast two elements */
        if (numbers.length < 2) {
            System.out.print(" Invalid Input ");
            return null;
        }

        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        ;

        for (int i = 0; i < numbers.length; i++) {
            int currentNum = numbers[i];

            /* If current element is greater than  first then update both first and second */
            if (currentNum > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = currentNum;
            }

            /* If arr[i] is in between first and second then update second  */
            else if (currentNum > secondLargest && currentNum != firstLargest)
                secondLargest = currentNum;
        }

        if (secondLargest == Integer.MIN_VALUE) {
            System.out.print("There is no second largest element\n");
            return null;
        }

        return secondLargest;
    }
}
