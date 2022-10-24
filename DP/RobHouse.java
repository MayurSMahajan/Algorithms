package DP;

//https://leetcode.com/problems/house-robber/

public class RobHouse {
    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        int[] nums = {2,4,6,7,8};
        System.out.println(hr.rob(nums));
    }
}

class HouseRobber {
    public int rob(int[] nums) {
        if(isAllZero(nums)) return 0;
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

/*
 * Note: The above algorithm is 0s faster than 100% submissions, and uses 67.55% less memory.
 * Notice we have to manage an edge case in this solution, i.e. an array with all zeros
 * An array with all zeroes, if not handled produces TLE.
 * Initially I handled it by changing dp's all values to -1 and then checking if dp[index] != -1
 * That solution was only 22% faster and used the same memory.
 * Reason, Imagine the size of the array being 1000 elements, then we are creating a dp with 1000 
 * values and assigning all of them as -1.
 * 
 * That is optimized by writing a function that simply checks if the array only contains 0s
 * Now in the worst case we'll make nums.length checks but on an average we will find an answer in
 * say O(1), O(2), etc time.
 */
