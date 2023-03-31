//https://leetcode.com/problems/max-consecutive-ones-iii

class ConsecutiveOnes{
	public static void main(String[] args) {
        CO co = new CO();
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(co.longestOnes(nums, 2));
    }
}

class CO{
public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int start = 0;
        int end = 0;
        int zeroesFound = 0;

        while(end < nums.length){
            if(nums[end] == 0){
                zeroesFound++;
            }

            while(zeroesFound > k){
                if(nums[start] == 0){
                    zeroesFound--;
                }
                start++;
            }

            ans = Math.max(ans, (end - start + 1));
            end++;
        }

        return ans;
    }}