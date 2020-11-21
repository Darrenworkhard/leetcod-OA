class LRUCache {
    int max = 0;
    HashMap<Integer, Integer> hashMap = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        max = capacity;
        //LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder)
        //loadFactor when to double the memary size
        hashMap = new LinkedHashMap<>(capacity, 0.75f, true);
    }
    
    public int get(int key) {
        if(hashMap.containsKey(key))
            return hashMap.get(key);
        return -1;
    }
    
    public void put(int key, int value) {
        if(hashMap.containsKey(key))
        {
            hashMap.remove(key);
        }
        else if(hashMap.size() >= max)
        {
            for(int i : hashMap.keySet())
            {
                hashMap.remove(i);
                break;
            }
                
        }
        hashMap.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */