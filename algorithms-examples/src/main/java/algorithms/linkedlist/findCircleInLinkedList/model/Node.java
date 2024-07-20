package algorithms.linkedlist.findCircleInLinkedList.model;

public class Node {

    public int data; //public for code simplicity
    public Node next;

    public int flag; //Flag use only in LinkListCycleFinderUsingFlag

    public Node(int x) {
        data = x;
        next = null;

        flag =0;
    }

}
