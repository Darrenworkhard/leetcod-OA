//S1 9m O(n)
class Solution {
    public int calculate(String s) {
        int len;
        if(s==null || (len = s.length())==0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for(int i=0;i<len;i++){
            if (s.charAt(i) == ' ')
            {
                continue;
            }
            if(Character.isDigit(s.charAt(i))){
                num = s.charAt(i)-'0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1)))
                {
                    i++;
                    num = num * 10 + s.charAt(i)-'0';
                }
                
                if (sign == '+')
                {
                    stack.push(num);
                }
                else if (sign == '-')
                {
                    stack.push(-num);
                }
                else if (sign == '/')
                {
                    stack.push(stack.pop() / num);
                }
                else if (sign == '*')
                {
                    stack.push(stack.pop() * num);
                }
                
                num = 0;
            }
            else
            {
                sign = s.charAt(i);
            }
            
        }

        int re = 0;
        for(int i:stack){
            re += i;
        }
        return re;
    }
}

//S2 27m O(n)
class Solution {
    public int calculate(String input) {
        if(input.length() == 0) return 0;
        List<String> list = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        for(char c : input.toCharArray())
        {
            if(c != ' ')
            {
                if(Character.isDigit(c))
                {
                    cur.append(c);
                }
                else
                {
                    list.add(cur.toString());
                    list.add(c + "");
                    cur = new StringBuilder();
                }
            }
        }
        list.add(cur.toString());
        Deque<String> queue = new LinkedList<>();
        Deque<Integer> dq = new LinkedList<>();
        for(int i = 0; i < list.size(); i++)
        {
            String s = list.get(i);
            if(s.equals("*") || s.equals("/"))
            {
                int curNum = dq.pollLast();
                int nextNum = Integer.valueOf(list.get(++i));
                if(s.equals("*"))
                    dq.add(curNum * nextNum);
                else
                    dq.add(curNum / nextNum);
            }
            else if(s.equals("-") || s.equals("+"))
            {
                queue.add(s);
            }
            else
                dq.add(Integer.valueOf(s));
        }
        double ans = dq.pollFirst();
        while(!queue.isEmpty())
        {
            String s = queue.pollFirst();
            if(s.equals("+"))
            {
                ans += dq.pollFirst();
            }
            else if(s.equals("-"))
            {
                ans -= dq.pollFirst();
            }
        }
        return (int)ans;
    }
}