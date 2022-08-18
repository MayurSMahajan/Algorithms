public class MissingNum {
    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();
        int[] nums = {0,1,3};
        System.out.println(mn.missingNumber(nums));
    }
}

/**
 * MissingNumber Leetcode : https://leetcode.com/problems/missing-number/
 */
class MissingNumber {
    public int missingNumber(int[] nums) {
        //We will find the sum of complete array if the number was not missing
        //We will find the sum of nums
        //then simply subtract the complete sum and nums sum

        int complete_sum = 0;
        for (int i = 1; i <= nums.length; i++) {
            complete_sum += i;
        }
        
        int nums_sum = 0;
        for (int i : nums) {
            nums_sum += i;
        }

        return complete_sum - nums_sum;
    }
}