public class ImplementTrie_PrefixTree_208 {

    private final CharSet dummyHead;

    /** Initialize your data structure here. */
    public ImplementTrie_PrefixTree_208() {
        dummyHead = new CharSet();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        CharSet set = dummyHead;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (set.next[i] == null) set.next[i] = new CharSet();
            set = set.next[i];
        }
        set.isFinish = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        CharSet set = dummyHead;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (set.next[i] == null) return false;
            set = set.next[i];
        }
        return set.isFinish;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        CharSet set = dummyHead;
        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (set.next[i] == null) return false;
            set = set.next[i];
        }
        return true;
    }

    private static class CharSet {
        boolean isFinish;
        CharSet[] next;
        CharSet() { next = new CharSet[26]; }
    }

}
