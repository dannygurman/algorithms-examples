package algorithms.trie;

import algorithms.trie.trie1.TrieV1;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrieUnitTest {

    private int ver = 1;

    private Trie initTrie() {
        return new TrieV1();
    }

    @Test
    public void whenEmptyTrie_thenNoElements() {
        Trie trie = initTrie();
        assertFalse(trie.isEmpty());
    }

    @Test
    public void givenATrie_whenAddingElements_thenTrieNotEmpty() {
        Trie trie = createExampleTrie();
        assertFalse(trie.isEmpty());
    }

    @Test
    public void givenATrie_whenAddingElements_thenTrieHasThoseElements() {
        Trie trie = createExampleTrie();
        assertFalse(trie.containsNode("3"));
        assertFalse(trie.containsNode("vida"));
        assertTrue(trie.containsNode("Programming"));
        assertTrue(trie.containsNode("is"));
        assertTrue(trie.containsNode("a"));
        assertTrue(trie.containsNode("way"));
        assertTrue(trie.containsNode("of"));
        assertTrue(trie.containsNode("life"));
    }

    @Test
    public void givenATrie_whenLookingForNonExistingElement_thenReturnsFalse() {
        Trie trie = createExampleTrie();
        assertFalse(trie.containsNode("99"));
    }

    @Test
    public void givenATrie_whenDeletingElements_thenTreeDoesNotContainThoseElements() {
        Trie trie = createExampleTrie();
        assertTrue(trie.containsNode("Programming"));
        trie.delete("Programming");
        assertFalse(trie.containsNode("Programming"));
    }

    @Test
    public void givenATrie_whenDeletingOverlappingElements_thenDontDeleteSubElement() {
        Trie trie = initTrie();
        trie.insert("pie");
        trie.insert("pies");
        trie.delete("pies");
        assertTrue(trie.containsNode("pie"));
    }

    private Trie createExampleTrie() {
        Trie trie = initTrie();
        trie.insert("Programming");
        trie.insert("is");
        trie.insert("a");
        trie.insert("way");
        trie.insert("of");
        trie.insert("life");
        return trie;
    }

}
