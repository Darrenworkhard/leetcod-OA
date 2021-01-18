class RandomizedSet {

    HashMap<Integer, Integer> map = new HashMap<>();
    List<Integer> lists = new ArrayList<>();
    int minIndex = 0;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        else
        {
            minIndex = lists.size();
            map.put(val, minIndex);
            lists.add(minIndex, val);
        }
            
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        else
        {
            int index = map.get(val);
            int lastNumber = lists.get(lists.size()-1);
            map.put(lastNumber, index);
            lists.set(index, lastNumber);
            map.remove(val);
            lists.remove(lists.size()-1);
               
        }    
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        int random = rand.nextInt(map.size());
        return lists.get(random);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */