package algorithms.trie;

public interface Trie {

    boolean containsNode(String word);
    void insert(String word);
    void delete(String word);
    boolean isEmpty();
}
