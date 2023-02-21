// https://leetcode.com/problems/single-element-in-a-sorted-array
// LeetCode: 540
// Hint: Array is Sorted and Solution must be O(logn), ask yourself, which algorithm is O(logn) and operates on sorted data?
// Hint: Imagine an array, where the arr consists of adjacent pairs of equal numbers; 
// This arr's length will be even, each pair's first num will be on even index starting from 0, and second num will be on odd index.
// Now in our problem, we have one missing num, making the size of the arr odd, now think about the indices of adjacent pairs.
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums[0]!= nums[1]) return nums[0];

        int start = 0;
        int end = nums.length - 1;
        int mid;

        if(nums[end] != nums[end-1]) return nums[end];

        while(start <= end){
            mid = start + (end - start) / 2;
            if((nums[mid] != nums[mid-1]) && (nums[mid] != nums[mid+1])){
                return nums[mid];
            }
            if(((nums[mid] == nums[mid-1]) && ((mid-1)%2==0)) || ((nums[mid] == nums[mid+1]) && ((mid+1)%2!=0))){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return nums[start];
    }
}
