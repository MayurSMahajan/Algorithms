//34. Find First and Last Position of Element in Sorted Array
//Facebook Question.
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

public class FirstAndLastPos {
    public static void main(String[] args) {
        SearchRange sr = new SearchRange();
        int[] nums = { 1, 1, 4, 4, 4, 4, 5, 6, 7, 7 };
        int target = 5;
        int[] ans = sr.searchRangeBetter(nums, target);
        for (int i : ans) {
            System.out.println(i);
        }
    }
}

class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = { -1, -1 };
        if (nums.length == 0) {
            return ans;
        }

        ans[0] = findFirstIndex(nums, target);

        // if target does not exist in nums;
        if (ans[0] == -1) {
            return ans;
        }

        // now since target exists in num we will search in its left and right until we
        // keep finding it.

        int left = ans[0] - 1;
        int right = ans[0] + 1;

        if (left >= 0) {
            while (nums[left] == target) {
                left--;
                if(left < 0){
                    break;
                }
            }
        }

        if (right < nums.length) {
            
            while (nums[right] == target) {
                right++;
                if(right == nums.length){
                    break;
                }
            }
        }

        ans[0] = left + 1;
        ans[1] = right - 1;

        return ans;
    }

    public int findFirstIndex(int[] nums, int target) {
        // search using binary search.
        int begin = 0;
        int end = nums.length - 1;

        while (begin <= end) {
            int mid = (begin + end) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid]) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return -1;
    }

    public int[] searchRangeBetter(int[] nums, int target){
        int[] ans = { -1, -1 };
        if (nums.length == 0) {
            return ans;
        }

        int begin = 0;
        int end = nums.length - 1;

        //search for the leftmost occurance.
        while(begin <= end){
            int mid = (begin + end) /2;

            if(nums[mid] == target){
                ans[0] = mid;
                end = mid - 1;
            }
            else if(nums[mid] > target){
                end = mid - 1;
            }
            else{
                begin = mid + 1;
            }
        }

        begin = 0;
        end = nums.length - 1;

        //search for the leftmost occurance.
        while(begin <= end){
            int mid = (begin + end) /2;

            if(nums[mid] == target){
                ans[1] = mid;
                begin = mid + 1;
            }
            else if(nums[mid] < target){
                begin = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

        return ans;
    }
}