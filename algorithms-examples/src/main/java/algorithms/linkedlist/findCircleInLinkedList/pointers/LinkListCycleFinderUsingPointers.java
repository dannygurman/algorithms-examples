package algorithms.linkedlist.findCircleInLinkedList.pointers;

import algorithms.linkedlist.findCircleInLinkedList.LinkListCycleFinder;
import algorithms.linkedlist.findCircleInLinkedList.model.Node;

public class LinkListCycleFinderUsingPointers implements LinkListCycleFinder {

/*  Time complexity: O(N), Only one traversal of the loop is needed.
    Auxiliary Space: O(1).
    */

    @Override
    public boolean detectLoop(final Node head) {
        Node slow_p = head; //slow pointer
        Node fast_p = head; //fast pointer

 //need to check also fast_p.next to avoid null pointer exception when calling fast_p = fast_p.next.next
        while (slow_p != null && fast_p != null && fast_p.next != null) {

            slow_p = slow_p.next;
            fast_p = fast_p.next.next; //twice fastest

            if (slow_p == fast_p) {
                //break and return loop detected
                return true;
            }
        }

        //two iteration were ended (slow + fast) OR - loop detected
        return false;

    }
}
