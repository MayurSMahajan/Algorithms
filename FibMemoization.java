// Solution for https://leetcode.com/problems/climbing-stairs/ 
import java.util.*; 

public class FibMemoization{
    
    public static void main(String[] args) {
        // FibMemoization cs = new FibMemoization();
        // HashMap<Integer, Integer> map = new HashMap<>();
        // System.out.println(cs.climbStairs(8,map));

        Fibonacci fb = new Fibonacci();
        System.out.println(fb.fib(30));
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


// https://leetcode.com/problems/fibonacci-number/
// 100% faster and uses 78% less space.
class Fibonacci{
    public int fib(int n) {
        HashMap<Integer,Integer> memo = new HashMap<Integer,Integer>();
        return fibonacci(n, memo);
    }
    
    private int fibonacci(int n, HashMap<Integer,Integer> memo){
        
        if(n == 1 || n == 0 ) return n;
        if(memo.get(n) != null) return memo.get(n);
        
        memo.put(n, (fibonacci(n-1,memo)+fibonacci(n-2,memo)));
        return memo.get(n);
    }
}