class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length() || A.length() <= 1) return false;
        if(A.length() == 2)
        {
            String s = swap(A, 0, 1);
            return s.equals(B);
        }
        List<Integer> diff = new ArrayList<>();
        boolean[] a = new boolean[27];
        boolean[] b = new boolean[27];
        boolean same = false;
        for(int i = 0; i < A.length(); i++)
        {
            int indexA = A.charAt(i) - 'a';
            int indexB = B.charAt(i) - 'a';
            if(b[indexB] || a[indexA])
                same = true;
            a[indexA] = true;
            b[indexB] = true;
            if(indexA != indexB)
            {
                diff.add(i);
            }
        }

        if(diff.size() < 2)
        {
            for(int i = 0; i <= 26; i++)
            {
                //abc & abc
                if(a[i] != b[i])
                    return false;
            }
            //aa & aa
            return same;
        } 
        else
        {
            String s = swap(A, diff.get(0), diff.get(1));
            return s.equals(B);
        }
        
    }
    public String swap(String s, int x, int y)
    {
        if(s.equals("")) return "";
        char[] c = s.toCharArray();
        char temp = c[x];
        c[x] = c[y];
        c[y] = temp;
        return new String(c);
    }
}
