package algorithms.trie.trie2;

import algorithms.trie.Trie;
import algorithms.trie.trie1.TrieNodeV1;

import static algorithms.trie.trie2.TrieNodeV2.ALPHABET_SIZE;

/**
 * Using children array in TrieNode (mifht include null value)
 */
public class TrieV2 implements Trie {

    private TrieNodeV2 root;

    public TrieV2() {
        root = new TrieNodeV2();
    }

    private static int getCharIndex(char char1) {
      int charIndex = char1 - 'a';
      if (charIndex < 0){
          throw new  IllegalArgumentException("Unsupported char " + char1);
      }
      return charIndex;
    }

    // If not present, inserts key into trie
    // If the key is prefix of trie node, just marks leaf node
        public void insert(String word) {
        TrieNodeV2 current = root;

        for (int i = 0; i < word.length(); i++) {
            int index = getCharIndex(word.charAt(i));
            if (current.children[index] == null) {
                current.children[index] = new TrieNodeV2();
            }
            current = current.children[index];
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

    public void delete(String word) {
        delete(root, word, 0);
    }

    // Recursive function to delete a key from given Trie
    private TrieNodeV2 delete(TrieNodeV2 current, String word, int depthIndex) {

        // If last character of key is being processed
        if (depthIndex == word.length()) {
            // This node is no more end of word after removal of given key
            if (root.isEndOfWord) {
                root.isEndOfWord = false;
            }
            return root;
        }

        // If not last character, recur for the child
        // obtained using ASCII value
        int index = getCharIndex(word.charAt(depthIndex));
        root.children[index] =
            delete(root.children[index], word, depthIndex + 1);
        return root;
    }

}
