class Trie {
    class TrieNode{
        TrieNode[] list = new TrieNode[26];
        boolean isLeaf;
    }
    public TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode r = this.root;
        char[] words = word.toCharArray();
        for(int i = 0; i < word.length() ; i++){
            if(r.list[words[i] - 'a'] == null){
                r.list[words[i] - 'a'] = new TrieNode();  
            }
            if(i == word.length() - 1)
                r.list[words[i] - 'a'].isLeaf = true;
            r = r.list[words[i] - 'a'];
        }   
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode r = this.root;
        char[] words = word.toCharArray();
        for(int i = 0; i < word.length(); i++){
            if(r.list[words[i] - 'a'] == null)    return false;
            r = r.list[words[i] - 'a'];
            if(i == word.length() - 1 && r.isLeaf)    return true;
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode r = this.root;
        char[] words = prefix.toCharArray();
        for(int i = 0; i < prefix.length(); i++){
            if(r.list[words[i] - 'a'] == null)    return false;
            r = r.list[words[i] - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */