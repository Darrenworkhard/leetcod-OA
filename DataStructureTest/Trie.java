class Trie {

    class Node
    {
        boolean endOfWord;
        Node[] node = new Node[27];
    }
    Node node = null;
  
    /** Initialize your data structure here. */
    public Trie() {
        node = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        insert(word, node);
    }
    Node insert(String word, Node current)
    { 
        if(current == null)
            current = new Node();
        if(word.equals(""))
            current.endOfWord = true;
        else
        {
            // if(current.node[word.charAt(0)-'a'] == null)
            //     current.node[word.charAt(0)-'a'] = new Node();
            insert(word.substring(1), current.node[word.charAt(0)-'a']);

        }
            
        
        return current;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(word, node);
    }
    boolean search(String word, Node current)
    {
        if(current == null)
            return false;
        if(word.equals(""))
        {
            return current.endOfWord;
        } 
        return search(word.substring(1), current.node[word.charAt(0)-'a']);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return startsWith(prefix, node);
    }
    boolean startsWith(String word, Node current)
    {
        if(current == null)
            return false;
        if(word.equals(""))
        {
            return true;
        }
        
        return startsWith(word.substring(1), current.node[word.charAt(0)-'a']);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */