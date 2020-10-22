//Solution1
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids.length == 1) return asteroids;
        Stack<Integer> stack = new Stack<>();
        stack.add(asteroids[0]);
        for(int i = 1; i < asteroids.length; i++)
        {
            int num = asteroids[i];
            if(num < 0)
            {
                while(!stack.isEmpty() && Math.abs(num) > stack.peek() && stack.peek() > 0)
                {
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek() < 0)
                {
                    stack.add(num);
                }
                else if(stack.peek() + num == 0)
                    stack.pop();
                    
            }
            else
                stack.add(num);
        }
        int[] ans = new int[stack.size()];
        for(int i = stack.size()-1; i >= 0; i--)
        {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
//Solution 2
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids.length == 1) return asteroids;
        return dfs(asteroids);
    }
    int[] dfs(int[] asteroids)
    {
        if(asteroids.length == 1) return asteroids;
        boolean isCollide = false;
        List<Integer> lists = new ArrayList<>();
        
        for(int i = 0; i < asteroids.length-1; i++)
        {
            if(asteroids[i] > 0 && asteroids[i+1] < 0)
            {
                if(Math.abs(asteroids[i+1]) > asteroids[i])
                {
                    lists.add(asteroids[i+1]);
                }
                else if(Math.abs(asteroids[i+1]) < asteroids[i])
                {
                    lists.add(asteroids[i]);
                }
                isCollide = true;
                i++;
            }
            else
            {       
                lists.add(asteroids[i]);
                if(i == asteroids.length-2)
                {
                    lists.add(asteroids[i+1]);
                }
            }
            
        }
        int[] array = new int[lists.size()];
        for(int i = 0; i < lists.size(); i++)
        {
            array[i] = lists.get(i);
        }
        if(isCollide)
        {
            return dfs(array);
        }
        else
        {
            return array;
        }
    }
}