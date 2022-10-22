package DP;

//We have already solved this problem in ../FibMemoization.java. 
//But that one uses a HashMap for memoization thus it is significantly slower
//The following solution uses an int array and thus it is 100% faster and uses 78% less space on leetcode
public class ClimbingStairs {
    public static void main(String[] args) {
        InnerCS ics = new InnerCS();
        System.out.println(ics.climbStairs(6));
    }
}

/**
 * https://leetcode.com/problems/climbing-stairs/
 */
class InnerCS {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        return cs(n, memo);
    }
    
    public int cs(int n, int[] memo){
        if(n == 1 || n == 2 || n == 3) return n;
        if(memo[n] != 0) return memo[n];
        
        int ans = cs(n-1, memo) + cs(n-2, memo);
        memo[n] = ans;
        return ans;
    }
}
