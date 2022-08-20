// LeetCode : https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
import java.util.ArrayList;

public class MinRecolors {
    public static void main(String[] args) {
        MinRecolorSol s = new MinRecolorSol();
        System.out.println(s.minimumRecolors("WWBBBWBBBBBWWBWWWB", 16));
        // System.out.println(s.minimumRecolors("WWBBW", 3));
    }
}

class MinRecolorSol {
    public int minimumRecolors(String blocks, int k) {
        int front_pointer = 0;
        int back_pointer = k;
        
        if(k == blocks.length()){
            return countWs(blocks);
        }
        
        ArrayList<Integer> countOfWs = new ArrayList<Integer>();
        while(back_pointer < blocks.length()+1){
            String subArr = blocks.substring(front_pointer, back_pointer);
            System.out.println(subArr);
            countOfWs.add(countWs(subArr));
            front_pointer++;
            back_pointer++;
        }
        
        //find the minimum sequence with ws
        int ans = k;
        for(Integer el : countOfWs){
            ans = Math.min(ans,el);
        }
        
        return ans;
    }
    
    private int countWs(String subStr){
        int count = 0;
        for(String c : subStr.split("")){
            if(c.equals("W")){
                count++;
            }
        }
        return count;
    }
}