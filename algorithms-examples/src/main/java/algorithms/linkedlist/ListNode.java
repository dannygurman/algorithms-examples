package algorithms.linkedlist;


import java.util.Objects;

//Definition for singly-linked list.
public class ListNode {

    public Integer val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * Adds a new value to the list.
     * If this node's value is null, set it as the head (assign the value here).
     * Otherwise, append a new node at the end.
     */
    /**
     * Adds a new node with the given value.
     * If this node has no value (null), initialize it as the head and return itself.
     * Otherwise, append to the end and return the newly added node.
     */
    public ListNode add(int newVal) {
        if (this.val == null) {
            this.val = newVal;
            return this; // return head when initializing
        }

        ListNode current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(newVal);
        return current.next; // return the node just added
    }

    /**
     * Utility: prints the list.
     */
    public void printList() {
        ListNode current = this;
        while (current != null) {
            System.out.print(current.val + (current.next != null ? " -> " : ""));
            current = current.next;
        }
        System.out.println();
    }

    /**
     * Compares two lists by their values (not references).
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ListNode)) return false;

        ListNode a = this;
        ListNode b = (ListNode) obj;

        while (a != null && b != null) {
            if (!Objects.equals(a.val, b.val)) return false;
            a = a.next;
            b = b.next;
        }
        return a == null && b == null;
    }

    /**
     * Generates hash code based on list contents.
     */
    @Override
    public int hashCode() {
        int result = 1;
        ListNode current = this;
        while (current != null) {
            result = 31 * result + Objects.hashCode(current.val);
            current = current.next;
        }
        return result;
    }


    /**
     * For better test failure messages.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }
        return sb.toString();
    }
}