package algorithms.linkedlist.findCircleInLinkedList;

import algorithms.linkedlist.findCircleInLinkedList.flag.LinkListCycleFinderUsingFlag;
import algorithms.linkedlist.findCircleInLinkedList.hashing.LinkListCycleFinderUsingHash;
import algorithms.linkedlist.findCircleInLinkedList.model.LinkedList;
import org.junit.Assert;
import org.junit.Test;

public class LinkListCycleFindTest {

    @Test
     public void testUsingHashFinder() {
         LinkListCycleFinder linkListCycleFinder = new LinkListCycleFinderUsingHash();
         testInternal(linkListCycleFinder);
     }

    @Test
    public void testUsingHashFlag() {
        LinkListCycleFinder linkListCycleFinder = new LinkListCycleFinderUsingFlag();
        testInternal(linkListCycleFinder);
    }


    private void testInternal(LinkListCycleFinder linkListCycleFinder){
        LinkedList linkedList = new LinkedList();

        linkedList.push(20);
        linkedList.push(4);
        linkedList.push(15);
        linkedList.push(10);

        /*Create loop for testing ! */
        linkedList.head.next.next.next.next = linkedList.head;

        boolean loopDetected =  linkListCycleFinder.detectLoop(linkedList.head);
        Assert.assertEquals(true, loopDetected);

    }
}
