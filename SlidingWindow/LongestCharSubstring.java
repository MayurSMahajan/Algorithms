//424. Longest Repeating Character
// https://leetcode.com/problems/longest-repeating-character-replacement/description/
//Faster than 82%

public class LongestRepeatingChar {
    public static void main(String[] args) {
        LRC l = new LRC();
        System.out.println(l.characterReplacement("ABAB", 2 ));
        System.out.println(l.characterReplacement("AABABBA", 1 ));
    }
}

class LRC{
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int ans = 0;
        int maxFreq = 0;
        int start = 0;
        int end = 0;

        while(end < s.length()){
            maxFreq = Math.max(addCharAndReturn(count, s.charAt(end)), maxFreq);
            while(((end - start + 1) - maxFreq) > k){
                removeCharAndReturn(count, s.charAt(start));
                start++;
            }
            ans = Math.max(ans, (end - start + 1));
            end++;
        }
        return ans;
    }

    int addCharAndReturn(int[] count, int index){
        index -= 65;
        count[index] = count[index] + 1;
        return count[index];
    }

    void removeCharAndReturn(int[] count, int index){
        index -= 65;
        count[index] = count[index] - 1;
    }
}