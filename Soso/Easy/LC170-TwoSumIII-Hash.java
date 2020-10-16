class TwoSum {
    Map<Integer, Integer> map = new HashMap<>();

    /** Initialize your data structure here. */
    public TwoSum() {
        
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.putIfAbsent(number, 0);
        map.put(number, map.get(number) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(int number : map.keySet())
        {
            if(map.get(number) > 1 && number * 2 == value)
                return true;
            else if(map.containsKey(value-number) && value-number != number)
                return true;
        }
        
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
