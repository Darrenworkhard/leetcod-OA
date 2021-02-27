package Normal.Medium;
import java.util.*;
public class LC_946_ValidateStackSequences {
    //O(n), O(n)
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length == 0) return true;
        Deque<Integer> dq = new LinkedList<>();
        int poppedIndex = 0;
        for(int pushedIndex = 0; pushedIndex < pushed.length; pushedIndex++)
        {
            dq.addFirst(pushed[pushedIndex]);
            while(!dq.isEmpty() && popped[poppedIndex] == dq.peekFirst())
            {
                dq.pollFirst();
                poppedIndex++;
            }
        }
        
        return dq.isEmpty();
    }
}
