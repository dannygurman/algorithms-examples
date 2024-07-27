package algorithms.arrays.findArraySecondLargestElement;

import org.junit.Assert;
import org.junit.Test;

public class FindSecondLargestTest {

    @Test
    public void testFindSecondUsingSorting(){
        SecondLargestFinder secondLargestFinder = new SecondLargestFinderUsingSorting();
        testInternal(secondLargestFinder);
    }

    @Test
    public void testFindSecondUsingByTraversingArrayTwice(){
        SecondLargestFinder secondLargestFinder = new SecondLargestFinderByTraversingArrayTwice();
        testInternal(secondLargestFinder);
    }

    @Test
    public void testFindSecondByTraversingArrayOnce(){
        SecondLargestFinder secondLargestFinder = new SecondLargestFinderByTraversingArrayOnce();
        testInternal(secondLargestFinder);
    }

    private void testInternal(SecondLargestFinder secondLargestFinder){
        Integer numbers[] = { 12, 35, 1, 10, 34, 1 };
        Integer expected = 34;
        secondLargestFinder.findSecondLargest(numbers);
        Integer found = secondLargestFinder.findSecondLargest(numbers);
        Assert.assertEquals(expected, found);
    }
}
