package algorithms.linkedlist.findCircleInLinkedList.model;

public class LinkedList {

    public Node head; //Public though no best practice

    /* Inserts a new Node at front of the list. */
    public void push(int new_data)  {
        /* 1 & 2: Allocate the Node &  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

}
