package algorithms.trie.trie1;

import algorithms.trie.Trie;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class TrieNodeV1 {
    private final Map<Character, TrieNodeV1> children = new HashMap<>();
    private boolean endOfWord;
}
