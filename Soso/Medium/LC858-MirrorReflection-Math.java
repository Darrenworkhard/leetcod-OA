//https://leetcode.com/problems/mirror-reflection/discuss/141773/C%2B%2BJavaPython-1-line-without-using-any-package-or

// If p = odd, q = even: return 0
// If p = even, q = odd: return 2
// If p = odd, q = odd: return 1
class Solution {
    public int mirrorReflection(int p, int q) {
        while (p % 2 == 0 && q % 2 == 0) {
            p >>= 1; 
            q >>= 1;
        }
        return 1 - p % 2 + q % 2;
    }
}
