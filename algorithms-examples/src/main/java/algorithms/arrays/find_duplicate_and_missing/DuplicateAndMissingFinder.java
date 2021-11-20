package algorithms.arrays.find_duplicate_and_missing;

public abstract class DuplicateAndMissingFinder {

    protected FoundDuplicateAndMissingResult result = new FoundDuplicateAndMissingResult();

    //Given an unsorted array of size n.
    //Array elements are in the range from 1 to n (natural positive numbers).
    //One number from set {1, 2, …n} is missing and one number occurs twice in the array.
     public abstract FoundDuplicateAndMissingResult findDuplicateAndMissing(int [] numbers) ;

}
