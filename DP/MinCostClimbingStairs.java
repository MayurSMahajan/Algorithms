package DP;

/**
 * MinCostClimbingStairs - https://leetcode.com/problems/min-cost-climbing-stairs/
 * Tip : Not using Math.min() for finding the minimum improves the performance of the program
 * With Math.min() - 2s faster than 33%, and 67% less memory
 * Without Math.min() - 1s faster than 89.36% and 41MB less memory than 94%
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        MCCS mccs = new MCCS();
        int[] cost = {10,2,5,3,6,7,9,5,2,5,7,8,9,5,2,3,5,7,89,4,2,2,4,6,7,5,1,4,6,3,2,5,7,5,2,4,6,78,8,5,2,3,5,6,7,8,89,9,1,21,1,16,3,2,3,10,2,5,3,6,7,9,5,2,5,7,8,9,5,2,3,5,7,89,4,2,2,4,6,7,5,1,4,6,3,2,5,6,3,2,3};
        System.out.println(mccs.minCostClimbingStairs(cost));        
    }
}

class MCCS{
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        int oc = getCost(cost, cost.length - 1,dp);
        int tc = getCost(cost,cost.length - 2,dp);
        return oc > tc ? tc : oc;
    }
    
    int getCost(int[] cost, int index, int[] dp){
        if(index < 0) return 0;
        if(index == 0 || index == 1) return cost[index];
        if(dp[index] != 0) return dp[index];
        
        int oneStepCost = getCost(cost, index - 1, dp);
        int twoStepCost = getCost(cost, index - 2, dp);
        
        dp[index] = cost[index] + (oneStepCost > twoStepCost ? twoStepCost : oneStepCost);

        return dp[index];
    }
}