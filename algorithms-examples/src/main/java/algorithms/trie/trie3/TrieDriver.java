package algorithms.trie.trie3;

public class TrieDriver {

    public static void main(String[] args) {
        Trie trie = new TrieImpl();

        String[] inputStrings  = { "and", "ant", "do", "geek", "dad", "ball" };

        // Insert each string into the Trie
        for (String str : inputStrings) {
            trie.insert(str);
        }

        String[] searchQueryStrings   = { "do", "geek", "bat" };

        // Search for each string and print whether it is found in the Trie
        for (String query : searchQueryStrings) {
            System.out.println("Query String: " + query);
            if (trie.search(query)) {
                System.out.println("The query string is present in the Trie");
            }
            else {
                System.out.println("The query string is not present in the Trie");
            }
        }

    }
}
