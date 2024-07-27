package algorithms.trie.trie3;

/**
 * Insert:
 * Time Complexity:
 * O(maxLengthOfWord)
 * Auxiliary Space of n words
 * : O(n * maxLengthOfWord)
 *
 * Search:
 *  Time Complexity:
 *  * O(maxLengthOfWord)
 *  * Auxiliary Space of n words
 *  * : O(1)
 *
 */
public class TrieImpl implements Trie {
    TrieNode root;

    public TrieImpl() {
        root = new TrieNode();
    }

    @Override
    // Function to insert a key into the Trie
    public void insert(String keyword) {
        TrieNode currentNode = root;

        for (int i = 0; i < keyword.length(); i++) {

            //the index in the childs array
            int charIndex = getCharArrayIndex(keyword, i);

            if (currentNode.childNode[charIndex] == null) {
                currentNode.childNode[charIndex] = new TrieNode();
            }
            currentNode = currentNode.childNode[charIndex];
        }
        //marking word end
        currentNode.wordEnd = true;
    }

    @Override
    // Function to search for a key in the Trie
   public boolean search(String keyword) {

        TrieNode currentNode = root;

        for (int i = 0; i < keyword.length(); i++) {
            int index = getCharArrayIndex(keyword, i);

            if (currentNode.childNode[index] == null) {
                //Not found
                return false;
            }
            currentNode = currentNode.childNode[index];
        }

        boolean isWordEnd =  currentNode.wordEnd;
        return isWordEnd;
    }

    private int getCharArrayIndex(String keyword, int charIndex){
        return keyword.charAt(charIndex) - 'a';
    }
}

