//https://aonecode.com/aplusplus/interviewctrl/getInterview/87987122
//For loop is O(N)
//TreeMap each add/get is O(logN) - Red-black tree
//Total time complexity is O(N) + O(longN) = O(N)
public List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {

    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    int count = 0;
    for(int i = 0; i < s.length; i++)
    {
        if(s.charAt(i) == '|')
        {
            treeMap.put(i, count);
        }
        else
        {
            count++;
        }
    }
    List<Integer> ans = new ArrayList<>();
    for(int i = 0; i < startIndices.length; i++)
    {
        if(treeMap.floorEntry(endIndices.get(i)-1) == null || treeMap.ceilingEntry(startIndices.get(i)-1))
            ans.add(0);
        else
        {
            ans.add(treeMap.floorEntry(endIndices.get(i)-1) - treeMap.ceilingEntry(startIndices.get(i)-1));
        }
    }
    return ans;
    
}
