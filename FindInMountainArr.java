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
        int[] mountainArr = {0,1,2,4,2,1};
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
        
        
        return -1;
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
}


