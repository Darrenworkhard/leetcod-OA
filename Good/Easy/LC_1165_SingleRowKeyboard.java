package Good.Easy;

public class LC_1165_SingleRowKeyboard {
    public int calculateTime(String keyboard, String word) {
        int[] charIndex = new int[26];
        for(int i = 0; i < keyboard.length(); i++)
        {
            charIndex[keyboard.charAt(i)-'a'] = i;
        }
        int calculate = charIndex[word.charAt(0)-'a'];
        for(int i = 1; i < word.length(); i++)
        {
            calculate += Math.abs(charIndex[word.charAt(i)-'a'] -
                                  charIndex[word.charAt(i-1)-'a']);
        }
        return calculate;
    }
}
