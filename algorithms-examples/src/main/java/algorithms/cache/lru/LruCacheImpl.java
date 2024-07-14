package algorithms.cache.lru;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
        Analysis
        The key to solve this problem is using a double linked list
        which enables us to quickly move nodes.

        The LRU cache is a hash table of keys and double linked nodes.
        The hash table makes the time of get() to be O(1).

        The list of double linked nodes make the nodes adding/removal operations O(1).
        */

public class LruCacheImpl implements LRUCache {

    int capacity;
    Map<Integer, Node> keyToNodeMap = new HashMap<Integer, Node>();

    Node head = null;
    Node tail = null;

    public LruCacheImpl(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (keyToNodeMap.containsKey(key)) {
            Node node = keyToNodeMap.get(key);

            //removing searched node from its current position in the double linked list
            removeFromList(node);

            //set to head (recently used)
            setListHead(node);

            return node.value;
        }

        return -1;
    }

    public void set(int key, int value) {

        if (keyToNodeMap.containsKey(key)) {
            //If found in map
            Node old = keyToNodeMap.get(key);
            //replace value
            old.value = value;

            //removing searched node from its current position in the double linked list
            removeFromList(old);

            //set to head (recently used)
            setListHead(old);
        } else {
            //Not existing - creating new
            Node created = new Node(key, value);
            if (keyToNodeMap.size() >= capacity) {
                //Reach max capacity

                //removing first from map the least used in the tail (end) of the linked list(using key saved in node)
                keyToNodeMap.remove(tail.key);
                //removing also from linked list
                removeFromList(tail);
            }
            //adding new node to head of the linked list
            setListHead(created);

            //adding to map
            keyToNodeMap.put(key, created);
        }

    }


    public void printLinkedList() {
        Iterator<Integer> iterator = listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


    private void removeFromList(Node node) {
        if (node.pre != null) {
            node.pre.next = node.next;
        } else {
            //n is current head
            head = node.next;
        }

        if (node.next != null) {
            node.next.pre = node.pre;
        } else {
            // n is current end
            tail = node.pre;
        }

    }


    private void setListHead(Node n) {
        n.next = head;
        n.pre = null;

        if (head != null)
            head.pre = n;

        head = n;

        if (tail == null)
            tail = head;
    }

    private Iterator<Integer> listIterator() {
        return new Iterator<Integer>() {

            Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Integer next() {
                if (hasNext()) {
                    Integer data = current.value;
                    current = current.next;
                    return data;
                }
                return null;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Remove not implemented.");
            }

        };

    }


}
