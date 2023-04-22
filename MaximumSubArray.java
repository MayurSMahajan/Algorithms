// 53. Maximum Sub Array
// https://leetcode.com/problems/maximum-subarray
// 100% faster and uses 22% less memory

public class MaximumSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,-1,3,4,-1,2,1,5,4};
        MaximumSubArraySolution ms = new MaximumSubArraySolution();
        System.out.println(ms.maxSubArray(nums));
    }
}

class MaximumSubArraySolution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = 0;

        for(int el : nums){
            if (currSum < 0){
                currSum = 0;
            }
            currSum += el;
            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum;
    }
}