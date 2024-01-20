package algorithms.arrays.arrayshuffle.ex2;

import java.util.Arrays;
import java.util.Random;

public class ModernFisherYatesAlgorithm {

    static void rand(int array[]) {
        // Creating object for Random class
        Random rd = new Random();

        // Starting from the last element and swapping one by one.
        for (int i = array.length - 1; i > 0; i--) {
            // Pick a random index from 0 to i
            int j = rd.nextInt(i + 1);
            // Swap array[i] with the element at random index
            swap(array, i, j);

        }
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        rand(array);

        // Printing the random generated array
        System.out.println(Arrays.toString(array));
    }
}
