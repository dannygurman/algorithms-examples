package algorithms.linkedlist.findCircleInLinkedList.hashing;

import algorithms.linkedlist.findCircleInLinkedList.LinkListCycleFinder;
import algorithms.linkedlist.findCircleInLinkedList.model.Node;

import java.util.HashSet;
import java.util.Set;

public class LinkListCycleFinderUsingHash implements LinkListCycleFinder {

   /*
    Time complexity: O(N), Only one traversal of the loop is needed.
    Auxiliary Space: O(N), N is the space required to store the value in the hashmap.
    */

    @Override
    public boolean detectLoop(final Node head) {

        Node currentNode = head;

        Set<Node> nodeSet = new HashSet<Node>();

        while (currentNode != null) {
            // If we have already has this node in hashmap it means there is a cycle
            // (Because you we encountering the node second time).
            if (nodeSet.contains(currentNode)){
                return true;
            }
            // If we are seeing the node forthe first time, insert it in hash
            nodeSet.add(currentNode);

            currentNode = currentNode.next;
        }
        return false;
    }
}
