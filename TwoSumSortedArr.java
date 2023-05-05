// 167. Two Sum II - Input Array Is Sorted
// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
// faster than 6% submissions and 38% memory efficient
public class TwoSumSortedArr {
    public static void main(String[] args) {
        int[] nums = {1,2,4,6,7,8,10,11,12};
        TwoSumSortedArrSolution t = new TwoSumSortedArrSolution();
        for(int i : t.twoSum(nums, 13)){
            System.out.println(i);
        }
    }
}

class TwoSumSortedArrSolution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = {-1,-1};
        for(int i=0; i< numbers.length - 1; i++){
            int diff = target - numbers[i];
            int mid;
            int start = i+1;
            int end = numbers.length - 1;

            while(start <= end){
                mid = start + (end - start) / 2;
                if(numbers[mid] == diff){
                    ans[0] = i+1;
                    ans[1] = mid+1;
                    return ans;
                }
                if(numbers[mid] > diff){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }
        }
        return ans;
    }
}