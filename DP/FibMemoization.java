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

//https://leetcode.com/problems/n-th-tribonacci-number/submissions/
//The key takeway from this function below is that array access is significantly faster than hash access
//With using hash the same program was only 10% faster and used 45% less space
//With using array for memoization the program is 100% faster and uses 63% less space.

class Tribonacci{
    public int tribonacci(int n) {
        int[] memo = new int[n+1];
        return tribo(n, memo);
    }
    
    int tribo(int n, int[] memo){
        if(n == 0) return 0;
        if(n == 2|| n == 1) return 1;
        
        if(memo[n] != 0) return memo[n];
        
        memo[n] = (tribo(n-1,memo) + tribo(n-2,memo) + tribo(n-3,memo));
         
        return memo[n];
    }
}