//Solution 1 98%
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        Arrays.sort(logs, (a,b)->{
            int identA = a.indexOf(" ") + 1;
            int identB = b.indexOf(" ") + 1;

            boolean isLetterA = Character.isLetter(a.charAt(identA));
            boolean isLetterB = Character.isLetter(b.charAt(identB));
            if(isLetterA && isLetterB){
                int cmp = a.substring(identA).compareTo(b.substring(identB));
                if(cmp != 0) return cmp;
                
                return a.compareTo(b);
            }else if(isLetterA && !isLetterB){
                return -1;
            }else if(!isLetterA && isLetterB){
                return 1;
            }else return 0;
            
        });
        
        return logs;
    }
}
//Solution 2 35%
//Original solved
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if(logs.length == 0) return new String[0];
        
        PriorityQueue<String> qString = new PriorityQueue<>((x,y) -> {
            String removeX = x.split(" ")[0];
            String subX = x.substring(removeX.length());
            String removeY = y.split(" ")[0];
            String subY = y.substring(removeY.length());
            if(subX.equals(subY))
                return removeY.compareTo(removeX);
            else
                return subY.compareTo(subX);
        });
        List<String> digits = new ArrayList<>();
        for(String s : logs)
        {
            int idenx = s.indexOf(" ") + 1;
            boolean isLetter = Character.isLetter(s.charAt(idenx));
            if(isLetter)
            {
                qString.add(s);
            }
            else
            {
                digits.add(s);
            }
        }
        while(!qString.isEmpty())
        {
            digits.add(0, qString.poll());
        }
        return digits.toArray(new String[0]);
    }
}