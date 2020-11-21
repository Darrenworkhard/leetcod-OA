class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> stackS = new Stack<>();
        Stack<Integer> stackI = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int num = 0;
        for(char c : s.toCharArray())
        {
            if(Character.isDigit(c))
            {
                num = num * 10 + c - '0';
            }
            else if(c == '[')
            {
                stackS.add(cur);
                stackI.add(num);
                cur = new StringBuilder();
                num = 0;
            }
            else if(c == ']')
            {
                StringBuilder temp = cur;
                cur = stackS.pop();
                int count = stackI.pop();
                while(count-- > 0)
                {
                    cur.append(temp);
                }
                //stackS.add(cur);
            }
            else
                cur.append(c);
        }
        return cur.toString();
    }
}