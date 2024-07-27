package algorithms.trie.trie3;

public class TrieNode {

    final static int NUM_OF_ENGLISH_CHARS = 26;

    TrieNode[] childNode;
    boolean wordEnd;


    public TrieNode() {
        this.childNode = new TrieNode[NUM_OF_ENGLISH_CHARS];
        this.wordEnd = false;
    }
}
