package algorithms.trie;

public interface Trie {

    boolean containsNode(String word);
    void insert(String word);
    boolean delete(String word);
    public boolean isEmpty();
}
