package algorithms.trie.trie2;

import algorithms.trie.trie1.TrieNodeV1;

import static algorithms.trie.trie2.TrieNodeV2.ALPHABET_SIZE;

/**
 * Using children array in TrieNode (mifht include null value)
 */
public class TrieV2 {

    private TrieNodeV2 root;

    public TrieV2() {
        root = new TrieNodeV2();
    }

    private static int getCharIndex(char char1) {
      return char1 - 'a';
    }

    // If not present, inserts key into trie
    // If the key is prefix of trie node, just marks leaf node
        public void insert(String word) {
        TrieNodeV2 current = root;

        for (int i = 0; i < word.length(); i++) {
            int index = getCharIndex(word.charAt(i));
            TrieNodeV2 childNodeAtIndex = current.children[index];
            if (childNodeAtIndex == null) {
                childNodeAtIndex = new TrieNodeV2();
            }
            current = childNodeAtIndex;
        }

        // mark last node as leaf
        current.isEndOfWord = true;
    }

    // Returns true if key presents in trie, else
    // false
    public boolean containsNode(String word) {
        TrieNodeV2 current = root;

        for (int i = 0; i < word.length(); i++) {
            int index = getCharIndex(word.charAt(i));
            TrieNodeV2 childNodeAtIndex = current.children[index];
            if (childNodeAtIndex == null) {
                return false;
            }
            current = childNodeAtIndex;
        }
        return (current.isEndOfWord);
    }


    // Returns true if root has no children, else false
    public boolean isEmpty() {
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (root.children[i] != null) {
                return false;
            }
        }
        return true;
    }

    // Recursive function to delete a key from given Trie
    static TrieNode remove(TrieNode root, String key, int depth) {
        // If tree is empty
        if (root == null) {
            return null;
        }

        // If last character of key is being processed
        if (depth == key.length()) {

            // This node is no more end of word after
            // removal of given key
            if (root.isEndOfWord) {
                root.isEndOfWord = false;
            }

            // If given is not prefix of any other word
            if (isEmpty(root)) {
                root = null;
            }

            return root;
        }

        // If not last character, recur for the child
        // obtained using ASCII value
        int index = key.charAt(depth) - 'a';
        root.children[index] =
            remove(root.children[index], key, depth + 1);

        // If root does not have any child (its only child got
        // deleted), and it is not end of another word.
        if (isEmpty(root) && root.isEndOfWord == false) {
            root = null;
        }

        return root;
    }

}
