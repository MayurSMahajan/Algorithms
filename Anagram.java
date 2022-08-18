/**
 * Anagram LeetCode : https://leetcode.com/problems/valid-anagram/
 */
public class Anagram {
    public static void main(String[] args) {
        CheckAnagram ca = new CheckAnagram();
        System.out.println(ca.isAnagram("mayur", "mumya"));
    }
}

class CheckAnagram{
    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        
        for (char st : s.toCharArray()) {
            int indexOfChar = t.indexOf(st);
            if(indexOfChar == -1){
                return false;
            }
            // if we get an index then we will simply remove that occurance.
            String prefix = t.substring(0,indexOfChar);
            String suffix = "";
            if(indexOfChar != t.length()){
                suffix = t.substring(indexOfChar+1, t.length());
            }
            t = prefix + suffix; 
        }

        if(t.isEmpty()){
            return true;
        }
        return false;
    }
}