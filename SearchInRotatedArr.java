// LeetCode 33
//https://leetcode.com/problems/search-in-rotated-sorted-array/

public class SearchInRotatedArr {
    public static void main(String[] args) {
        SIRA sira = new SIRA();
        int[] nums = {1,3,2};
        int target = 1;
        System.out.println(sira.search(nums, target));
    }
}

class SIRA {
    public int search(int[] nums, int target) {

        //handling edge case
        if(nums.length == 1){
            return (nums[0] == target) ? 0 : -1;
        }
        
        //when an asc arr is pivoted it creates two ascending sub arrays separated by the peak.
        //so we will conduct binary search in the ascending half and then 
        //in the descending half.
        //but first we will have to find the peak in the array using binary search.
        int peakIndex = findPeak(nums);
        //check if peak element is target or not
        System.out.println(peakIndex);
        
        if(peakIndex == -1){
            return binarySearch(nums, target, 0, nums.length);
        }

        if(nums[peakIndex] == target){
            return peakIndex;
        }

        //now that we have two subarrays, we know both subarrays are ascending since
        //we have pivoted them from an ascending array
        //so now we will simply apply binary search on these sorted arrays.
        // ans = binarySearch(nums, target, 0, peakIndex - 1);
        // return (ans == -1) ? binarySearch(nums, target, peakIndex + 1, nums.length - 1) : ans;

        //we can add one more set of cases, if the target is greater than first element,
        //then we only have to search the left hand sub array from first till peak,
        //since no element after peak will exceed the first el in the array since
        //this array is a rotated sorted array. Thus,
        if(target >= nums[0]){
            return binarySearch(nums, target, 0, peakIndex - 1);
        }

        return binarySearch(nums, target, peakIndex + 1, nums.length - 1);
    }   
    
    public int findPeak(int[] nums){

        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(mid < end && nums[mid] > nums[mid + 1]){
                return mid;
            }
            if(mid > start && nums[mid] < nums[mid - 1]){
                return mid - 1;
            }
            if(nums[mid] >= nums[start]){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

        return -1;
    }

    public int binarySearch(int[]nums, int target, int start, int end){
        
        while(start <= end){
            int mid = start + (end - start)/2;
            System.out.println("M = "+mid);
            if(nums[mid] == target){
                return mid;
            }
            if(target > nums[mid]){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

        return -1;
    }
}