package algorithms.linkedlist.findCircleInLinkedList;

import algorithms.linkedlist.findCircleInLinkedList.model.Node;

public interface LinkListCycleFinder {

    // Returns true if there is a loop in linked
    // list else returns false.
    boolean detectLoop(final Node head);

}
