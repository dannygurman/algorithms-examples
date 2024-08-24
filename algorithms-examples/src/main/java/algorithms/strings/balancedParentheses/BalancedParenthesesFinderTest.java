package algorithms.strings.balancedParentheses;

import org.junit.Assert;
import org.junit.Test;

public class BalancedParenthesesFinderTest {

    @Test
    public void testBalancedParenthesesFinderUsingStackAndMap() {
        BalancedParenthesesFinder finder = new BalancedParenthesesFinderUsingStackAndMap();
        testBalancedParenthesesFinderInternal(finder);
    }

    @Test
    public void testBalancedParenthesesFinderUsingDeque() {
        BalancedParenthesesFinder finder = new BalancedParenthesesFinderUsingDeque();
        testBalancedParenthesesFinderInternal(finder);
    }

    private void testBalancedParenthesesFinderInternal(BalancedParenthesesFinder finder) {
        String expr1 = "([{}])";
        boolean result1 = finder.isValid(expr1);
        Assert.assertEquals(true, result1);

        String expr2 = "([{}]]]";
        boolean result2 = finder.isValid(expr2);
        Assert.assertEquals(false, result2);
    }
}
