import java.util.*;

// 76. https://leetcode.com/problems/minimum-window-substring/

public class MinWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        MWS mws = new MWS();
        System.out.println(mws.minWindow(s, t));
    }
}

class MWS {
    public String minWindow(String s, String t) {
        
        //We are simply storing the frequency of our characters in s
        HashMap<Character, List<Integer>> freqMap = new HashMap<Character, List<Integer>>();
        for(int i = 0; i < s.length(); i++){
            Character charAtI = s.charAt(i);
            if(t.contains(charAtI.toString())){
                List<Integer> temp = new ArrayList<Integer>();
                if(freqMap.get(s.charAt(i)) != null){
                    temp = freqMap.get(s.charAt(i));
                }
                temp.add(i);
                freqMap.put(s.charAt(i), temp);
            }
        }
        
        //if any one character in t is not present in our freqMap, that means we can never
        //create a substring from s that contains t, and in that case :
        if(freqMap.size() < t.length()){
            return "";
        }
        
        //figure out some way to iterate through all the lists to generate a permutation
        //[[1,12],[2,10],[7]] -> 1-2-7, 1-10-7, 12-2-7, 12-10-7
        
        return s;
    }
}

class MyMapSet{
    List<Integer> myMaps;
    Integer low;
    Integer high;
    
    MyMapSet(List<Integer> myMaps){
        this.myMaps = myMaps;
        getHigh();
        getLow();
    }
    
    Integer getDiff(){
        return (high - low) + 1;
    }
    
    void getHigh(){
        high = myMaps.get(0);
        
        for(int i= 1; i< myMaps.size(); i++){
            Integer curr_val = myMaps.get(0);
            if(curr_val > high){
                high = curr_val;
            }
        }
        
    }
    
    void getLow(){
        low = myMaps.get(0);
        
        for(int i= 1; i< myMaps.size(); i++){
            Integer curr_val = myMaps.get(0);
            if(curr_val < low){
                low = curr_val;
            }
        }
        
    }
    
}
