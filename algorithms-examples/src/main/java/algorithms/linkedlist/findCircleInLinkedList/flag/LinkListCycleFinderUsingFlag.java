package algorithms.linkedlist.findCircleInLinkedList.flag;

import algorithms.linkedlist.findCircleInLinkedList.LinkListCycleFinder;
import algorithms.linkedlist.findCircleInLinkedList.model.Node;

public class LinkListCycleFinderUsingFlag implements LinkListCycleFinder {

    @Override
    public boolean detectLoop(Node head) {

        Node currentNode = head;

        while (currentNode != null) {

            // If this node is already traverse it means there is a cycle
            // (Because we encounted the node for the second time).
            if (currentNode.flag == 1) {
                return true;
            }

            // If we are seeing the node for
            // the first time, mark its flag as 1
            currentNode.flag = 1;

            currentNode = currentNode.next;
        }
        return false;
    }
}
