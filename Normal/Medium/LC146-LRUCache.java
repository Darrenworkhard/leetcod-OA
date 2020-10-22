//Solution 1 80%
class LRUCache {
    int max;
    Map<Integer, Integer> map = new LinkedHashMap<>();
    
    public LRUCache(int capacity) {
        max = capacity;
        //Key point true = access order, default false = insertion order
        //When you use map.keySet() the oreder are different because the setting
        map = new LinkedHashMap<>(capacity, 0.75f, true);
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {      
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key))
        {
            map.remove(key);
        }
        else if(map.size() >= max)
        {
            for(int remove : map.keySet())
            {
                map.remove(remove);
                break;
            }
        }
       
        map.put(key, value);
    }
}


//Solution 2 5%
class LRUCache {
    int max;
    Deque<Integer> dq = new LinkedList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    
    public LRUCache(int capacity) {
        max = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            dq.remove(key);
            dq.add(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        map.put(key, value);
        if(dq.contains(key))
        {
            dq.remove(key);
        }
        dq.add(key);
        if(map.size() > max)
        {
            int remove = dq.removeFirst();
            map.remove(remove);
        }
    }
}

