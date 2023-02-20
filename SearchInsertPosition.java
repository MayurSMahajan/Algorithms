//https://leetcode.com/problems/search-insert-position/description/
//Tip: Binary Sort
class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        
        while(start <= end){
            
            mid = (start + end) / 2;
            if(target == nums[mid]){
                return mid;
            }
            if(target > nums[mid]){
                start = mid+1;
            }
            else if(target < nums[mid]){                
                end = mid-1;
            }
        }
        return start;
    }
}
