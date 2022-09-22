/**
 * ReverseWords - https://leetcode.com/problems/reverse-words-in-a-string-iii/submissions/
 */
public class ReverseWords {
    public static void main(String[] args) {
        InnerReverseWords irw = new InnerReverseWords();
        String str = "My Name is Anthony Gonzalves!";
        System.out.println(irw.reverseWords(str));
    }
}

class InnerReverseWords {
    public String reverseWords(String s) {
        String[] strArr = s.split(" ");
        String ans = " ";
        for(String str : strArr){
            ans += reverseWord(str) + " ";
        }
        return ans.trim();
    }
    
    public String reverseWord(String str){
        String ans = " ";
        for(Character c : str.toCharArray()){
            ans = c + ans;
        }
        return ans.trim();
    }
}