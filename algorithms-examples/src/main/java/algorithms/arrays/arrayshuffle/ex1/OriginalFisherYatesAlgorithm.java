package algorithms.arrays.arrayshuffle.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OriginalFisherYatesAlgorithm {

    // Function to perform Fisher-Yates Shuffle using the original method
    public static List<Character> fisherYatesShuffle(List<Character> list) {
        List<Character> output = new ArrayList<>(); // Create an output list to store the shuffled elements
        boolean[] visited = new boolean[list.size()]; // Create a boolean array to keep track of visited elements

        // Perform the shuffle algorithms
        for (int i = 0; i < list.size(); i++) {
            int j = generateRandomIndexInList(list); // Generate a random index in the input list
            while (visited[j]) { // Find the next unvisited index
                j = generateRandomIndexInList(list);
            }

            output.add(list.get(j)); // Add the element at the chosen index to the output list
            visited[j] = true; // Mark the element as visited
        }
        return output;
    }

    private static int generateRandomIndexInList(List<Character> list) {
        return new Random().nextInt(list.size());
    }

    public static void main(String[] args) {
        List<Character> arr = List.of('A', 'B', 'C', 'D', 'E', 'F');
        Random rand = new Random(); // Seed the random number generator with the current time
        List<Character> shuffledArray = fisherYatesShuffle(arr); // Call the shuffle function
        System.out.print("Shuffled array: ");
        for (char c : shuffledArray) {
            System.out.print(c + " "); // Print the shuffled array
        }
        System.out.println();
    }
}
