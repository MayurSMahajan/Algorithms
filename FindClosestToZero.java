//2239. https://leetcode.com/problems/find-closest-number-to-zero/

public class FindClosestToZero {
    public static void main(String[] args) {
        int[] nums = {-4,-2,1,4,8};
        IFCTZ ifctz = new IFCTZ();
        System.out.println(ifctz.findClosestNumber(nums));
    }
}

class IFCTZ {
    public int findClosestNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int difference = Math.abs(nums[i] - 0);
            if (difference < Math.abs(ans - 0)) {
                ans = nums[i];
                continue;
            }
            if (difference == Math.abs(ans - 0)) {
                ans = Math.max(ans, nums[i]);
                continue;
            }
        }
        return ans;
    }

}
