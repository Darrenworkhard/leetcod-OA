//package AlgorithmReview;

import java.util.*;

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
            insert(word.substring(1), current.node[word.charAt(0)-'a']);
        
        return current;
    }
    
    /** Returns if the word is in the trie. */
    //public boolean search(String word) {
    public boolean search() {

        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                Node n = q.poll();
                
            }
        }
        //return search(word, node);
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
