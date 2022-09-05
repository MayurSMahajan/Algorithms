import java.util.*;

public class LongestSubstring {
    public static void main(String[] args) {
        LS ls = new LS();
        System.out.println(ls.lengthOfLongestSubstring("dvdf"));
    }
}

 /**
  * LS - https://leetcode.com/problems/longest-substring-without-repeating-characters/
  */
class LS {
    public int lengthOfLongestSubstring(String s) {
        int current_ans = 0;
        int best_ans = 0;
        HashMap<Character,Integer> uniqueChars = new HashMap<Character,Integer>();

        int begin = 0;
        int end = 0;

        while (end < s.length()) {
            // System.out.println("c= "+ current_ans + " --- b = " + best_ans + " --- begin = "+begin + " Size of HashMap = "+ uniqueChars.size());
            //check if the char exists in the hashmap
            if(uniqueChars.get(s.charAt(end)) == null){
                uniqueChars.put(s.charAt(end), 1);
                current_ans += 1;
                best_ans = Math.max(current_ans, best_ans);
                end++;
            }
            else{
                current_ans = 0;
                uniqueChars.clear();
                end = ++begin;
            }
            
        }

        // System.out.println("c_a = "+ current_ans + " --- b_a = " + best_ans + " --- begin = "+begin + " Size of HashMap = "+ uniqueChars.size());
        return best_ans;
    }    


}
