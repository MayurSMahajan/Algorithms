// Solution for https://leetcode.com/problems/climbing-stairs/ 
import java.util.*; 

public class FibMemoization{
    
    public static void main(String[] args) {
        FibMemoization cs = new FibMemoization();
        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println(cs.climbStairs(8,map));
    }
    
    public int climbStairs(int n, HashMap<Integer, Integer> map) {
        int ans = 0;
        if(n == 1 || n == 2){
            return n;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        
        ans = climbStairs(n-1,map) + climbStairs(n-2,map);
        map.put(n,ans);
        return ans;
    }
}
