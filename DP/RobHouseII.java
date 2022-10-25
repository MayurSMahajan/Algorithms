package DP;

//https://leetcode.com/problems/house-robber-ii

public class RobHouseII {
    public static void main(String[] args) {
        RobII r = new RobII();
        // int[] nums = {2,4,6,7,8,7,3,6,78,65,42,4,656,67,3,42,3,45,6,57,67,5,3,422,3,5,656,7,68,7,8,34,23,5,56,57,8,4,5,42,6,567,68,8,6,45,4,3};
        int[] nums = {2,4,6,7,8};
        System.out.println(r.rob(nums));
    }
}

class RobII {
    public int rob(int[] nums) {
        if(isAllZero(nums)) return 0;
        if(nums.length == 1) return nums[0];
        
        int temp = nums[0];
        nums[0] = 0;
        
        int os = robHelper(nums);
        
        nums[0] = temp;
        nums[nums.length - 1] = 0;
    
        int ts = robHelper(nums);

        return os > ts ? os : ts;
    }
    
    int robHelper(int[] nums) {
        
        int size = nums.length;
        int[] dp = new int[size];
        
        int f = getMoney(nums, size - 1, dp);
        int s = getMoney(nums, size - 2, dp);
        return f > s ? f : s;
    }
    
    boolean isAllZero(int[] nums){
        for(int num : nums){
            if(num != 0) return false;
        }
        return true;
    }
    
    int getMoney(int[] nums, int index, int[] dp){
        if(index < 0) return 0;
        if(index == 0 || index == 1) return nums[index];
        if(dp[index] != 0) return dp[index];
        
        int firstHouseMoney = getMoney(nums, index - 2, dp);
        int secondHouseMoney = getMoney(nums, index - 3, dp);
        
        dp[index] = nums[index] + (firstHouseMoney > secondHouseMoney ? firstHouseMoney : secondHouseMoney);
        
        return dp[index];
    }
}