//https://aonecode.com/aplusplus/interviewctrl/getInterview/87987122

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
        if(treeMap.floorEntry(endIndices.get(i)-1) == null || treeMap.CilingEntry(startIndices.get(i)-1))
            ans.add(0);
        else
        {
            ans.add(treeMap.getFloor(endIndices.get(i)-1) - treeMap.getCiling(startIndices.get(i)-1));
        }
    }
    return ans;
    
}
