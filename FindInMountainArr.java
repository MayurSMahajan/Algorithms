//  // This is MountainArray's API interface.
//  // You should not implement it, or speculate about its implementation
// interface MountainArray {
//      public int get(int index); 
//      public int length();
// }
//LeetCode 1095
//https://leetcode.com/problems/find-in-mountain-array/

public class FindInMountainArr{
    public static void main(String[] args) {
        FIMA fima = new FIMA();
        int[] mountainArr = {0,1,3,4,2,1};
        int target = 2;
        System.out.println(fima.findInMountainArray(target, mountainArr));
    }
}
 
class FIMA {
    public int findInMountainArray(int target, int[] mountainArr) {
        //First find the peak in the mountain array.
        //The left side of the peak is an ascending arr.
        //The right side of the peak is a descending arr.
        //so after finding the mountain we will check for the target in the left part
        //if not found then we will look in the right part.
        
        int peak = findPeakInMountain(mountainArr);
        
        int result = binarySearch(mountainArr, target, 0, peak-1, true);
        if(-1 != result){
            return result;
        }

        if(mountainArr[peak] == target){
            return peak;
        }

        result = binarySearch(mountainArr, target, peak+1, mountainArr.length - 1, false);
        
        return result;
    }

    //implementing finding the mountain code
    //our original code for finding peak mountain array in our submission PeakIndexMountain,
    //returns any peak, here we only need the max peak, no two peaks will exist (constraints).
    public int findPeakInMountain(int[] mountainArr){
        
        int start = 0;
        int end = mountainArr.length - 1;

        while(start < end){
            int mid = start + (end - start)/2;

            if(mountainArr[mid] > mountainArr[mid + 1]){
                //this means we are in the asc part of the arr.
                end = mid;
            }
            else{
                //this means we are in the desc part of the arr.
                start = mid + 1;
            }
        }
        
        return start; //you can also return end since both will point to the same element.
    }    

    public int binarySearch(int[]nums, int target, int start, int end, boolean isAscending){
        
        if(isAscending){
            while(start <= end){
                int mid = start + (end - start)/2;
                
                int middleNum = nums[mid];
                if(middleNum == target){
                    return mid;
                }
                if(target > middleNum){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        else{
            while(start <= end){
                int mid = start + (end - start)/2;

                int middleNum = nums[mid];
                if(middleNum == target){
                    return mid;
                }
                if(target > middleNum){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        return -1;        
    }
}


