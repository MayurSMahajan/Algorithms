// Solution for https://leetcode.com/problems/first-unique-character-in-a-string/submissions/

import java.util.HashMap;

public class FirstUniChar {
    
    public static void main(String[] args) {
        S s = new S();
        System.out.println(s.firstUniqChar("LoveLeetCode"));
    }
}

class S {
    public int firstUniqChar(String s) {

        String[] strArr = s.split("");
        HashMap<String,Integer> map = new HashMap<String,Integer>();

        for (int i = 0; i < strArr.length; i++) {
            if(map.containsKey(strArr[i])){
                map.put(strArr[i], map.get(strArr[i]) + 1);
            }
            else{
                map.put(strArr[i],1);
            }
        }

        for (int i = 0; i < strArr.length; i++) {
            if(map.get(strArr[i]) == 1) return i;
        }
        
        return -1;
    }
}