package algorithms.strings.numOfOccurence;

public class NumOfOccurrenceFinderByRecursion implements  NumOfOccurrenceFinder{

    final static int NOT_FOUND_MARK = -1;

    @Override
    // Function to count the occurrences of an element in a SORTED array
    public int countOccurrences(int[] arr, int x) {
        int n = arr.length;
        // Find the first and last occurrences of the element
        int idxFirst = findFirstOccurrence(arr, 0, n - 1, x);

        // If the element does not exist, return -1
        if (idxFirst == NOT_FOUND_MARK) {
            return NOT_FOUND_MARK;
        }

        int idxLast = findLastOccurrence(arr, idxFirst, n - 1, x);

        // Return the difference between the last and first  occurrences + 1 to get the total count
        return idxLast - idxFirst + 1;
    }


    // Function to find the first occurrence of an element in a sorted array
    private int findFirstOccurrence(int[] arr, int low, int high, int x) {
        if (high >= low) {
            int mid = (low + high) / 2;

            // Check if the element is present at the middle or
            // if the element is present in the left half (if the element is greater than the middle element)
            if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x) {
                return mid;
            } else if (x > arr[mid]) {
                // Search in the right half
                return findFirstOccurrence(arr, mid + 1, high, x);
            } else {
                // Search in the left half
                return findFirstOccurrence(arr, low, mid - 1, x);
            }
        }
        //not found
        return NOT_FOUND_MARK;
    }


    // Function to find the last occurrence of an element in a sorted array
    private int findLastOccurrence(int[] arr, int low, int high, int x) {
        int n = arr.length;

        if (high >= low) {
            int mid = (low + high) / 2;
            // Check if the element is present at the middle or
            // if the element is present in the right half (if
            // the element is smaller than the middle element)
            if ((mid == n - 1 || x < arr[mid + 1]) && arr[mid] == x) {
                return mid;
            } else if (x < arr[mid]) {
                // Search in the left half
                return findLastOccurrence(arr, low, mid - 1, x);
            } else {
                // Search in the right half
                return findLastOccurrence(arr, mid + 1, high, x);
            }
        }

        //not found
        return NOT_FOUND_MARK;
    }



}
