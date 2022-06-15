package algorithms.trie.trie1;

import algorithms.trie.Trie;

import java.util.Map;

 // Using children map in TrieNode
public class TrieV1 implements Trie {

    private TrieNodeV1 root;

    public TrieV1() {
        root = new TrieNodeV1();
    }

   /* 1. Set a current node as a root node
      2. Set the current letter as the first letter of the word
      3. If the current node has already an existing reference to the current letter
      (through one of the elements in the “children” field), then set current node to that referenced node.
       Otherwise, create a new node, set the letter equal to the current letter,
        and also initialize current node to this new node
     4. Repeat step 3 until the key is traversed

     The complexity of this operation is O(n), where n represents the key size.
     */
    public void insert(String word) {
        TrieNodeV1 current = root;

        for (char currentChar : word.toCharArray()) {
            Map<Character, TrieNodeV1> childrens =  current.getChildren();
            current = childrens.computeIfAbsent(currentChar, c -> new TrieNodeV1());
        }
        current.setEndOfWord(true);
    }

    public void delete(String word) {
         delete(root, word, 0);
    }

    /**
     * Get children of the root
     * Iterate through each character of the String
     * Check whether that character is already a part of a sub-trie.
     *
     * If it isn't present anywhere in the trie, then stop the search and return false
     *
     * Repeat the second and the third step until there isn't any character left in the String.
     * If the end of the String is reached, return true
     *
     * The complexity of this algorithm is O(n), where n represents the length of the key.
     */
    public boolean containsNode(String word) {
        TrieNodeV1 current = root;

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            TrieNodeV1 node = current.getChildren().get(currentChar);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }

   public boolean isEmpty() {
        return root == null;
    }
    /**
     * Recursion
     * For the deletion process, we need to follow the steps:     *
     * Check whether this element is already part of the trie
     * If the element is found, then remove it from the trie
     *
     * The complexity of this algorithm is O(n), where n represents the length of the key.
     * @return - Should delete current node
     */
    private boolean delete(TrieNodeV1 current, String word, int depthIndex) {
        if (depthIndex == word.length()) {
            if (!current.isEndOfWord()) {
                //If we reach the end of word index - but it is not marked as end of word
                //the word does not found so we should NOT delete this node
                return false;
            }
            //The whole word is found - before deleting
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(depthIndex);
        TrieNodeV1 node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = (delete(node, word, depthIndex + 1)) && (! node.isEndOfWord());
        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }
}