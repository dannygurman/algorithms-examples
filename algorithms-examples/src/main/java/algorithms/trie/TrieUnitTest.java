package algorithms.trie;

import algorithms.trie.trie1.TrieV1;
import algorithms.trie.trie2.TrieV2;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class TrieUnitTest {

    //Set Implementation version
    private int trieVersion = 2;


    private Trie initTrie() {
        if (trieVersion == 1) {
            return new TrieV1();
        } else {
            return new TrieV2();
        }
    }

    @Test
    public void whenEmptyTrie_thenNoElements() {
        Trie trie = initTrie();
        assertTrue(trie.isEmpty());
    }

    @Test
    public void givenATrie_whenAddingElements_thenTrieNotEmpty() {
        Trie trie = createExampleTrie();
        assertFalse(trie.isEmpty());
    }

    @Test
    public void givenATrie_whenAddingElements_thenTrieHasThoseElements() {
        Trie trie = createExampleTrie();
        assertFalse(trie.containsNode("xxx"));
        assertFalse(trie.containsNode("vida"));

        assertTrue(trie.containsNode("programming"));
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
        assertTrue(trie.containsNode("programming"));
        trie.delete("programming");
        assertFalse(trie.containsNode("programming"));
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
        trie.insert("programming");
        trie.insert("is");
        trie.insert("a");
        trie.insert("way");
        trie.insert("of");
        trie.insert("life");
        return trie;
    }

}
