package algorithms.linkedlist.addTwoNumbers_2.code;

import algorithms.linkedlist.ListNode;
import org.junit.Assert;
import org.junit.Test;


public class TwoNumberAdderTest {

    @Test
    public void testTwoNumbersAdder_1() {
        TwoNumberAdder twoNumberAdder = new TwoNumberAdderImpl_1();
        verifyAddTwoNumbers(twoNumberAdder);
    }

    @Test
    public void testTwoNumbersAdder_2() {
        TwoNumberAdder twoNumberAdder = new TwoNumberAdderImpl_2();
        verifyAddTwoNumbers(twoNumberAdder);
    }

    private void verifyAddTwoNumbers(TwoNumberAdder twoNumberAdder) {
        ListNode l1 = new ListNode();
        l1.add(2).add(4).add(3);
        ListNode l2 = new ListNode();
        l2.add(5).add(6).add(4);
        ListNode expected = new ListNode();
        expected.add(7).add(0).add(8);
        verifyAddTwoNumbers(twoNumberAdder, l1, l2, expected);

        ListNode l10 = new ListNode();
        l10.add(9).add(9).add(9);
        ListNode l20 = new ListNode();
        l20.add(9).add(9).add(9);
        ListNode expected2 = new ListNode();
        expected2.add(8).add(9).add(9).add(1);
        verifyAddTwoNumbers(twoNumberAdder, l10, l20, expected2);
    }

    private void verifyAddTwoNumbers(TwoNumberAdder twoNumberAdder, ListNode l1,
                                     ListNode l2, ListNode expected) {
        ListNode result = twoNumberAdder.addTwoNumbers(l1, l2);
        Assert.assertEquals(expected, result);
    }
}
