class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        Deque<Character> dq = new LinkedList<>();
        char[] cA = s.toCharArray();
        for(int i = 0; i < cA.length; i++)
        {
            char c = cA[i];
            if(c == '(' || c == '[' || c == '{')
                dq.addLast(c);
            else
            {
                if(dq.size() == 0) return false;
                char match = dq.pollLast();
                if(c == ')')
                {
                    if(match != '(')
                        return false;
                }else if(c == ']')
                {
                     if(match != '[')
                        return false;
                }else if(c == '}')
                {
                    if(match != '{')
                        return false;
                }
            }
        }
        
        return dq.size() == 0;
    }
}