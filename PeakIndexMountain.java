//Leetcode 852
//https://leetcode.com/problems/peak-index-in-a-mountain-array/


public class PeakIndexMountain {
    public static void main(String[] args) {
        PIM pim = new PIM();
        int[] arr = {3,5,3,2,0};
        System.out.println(pim.peakIndexInMountainArray(arr));
    }
}

class PIM {
    public int peakIndexInMountainArray(int[] arr) {
        int ans = 0;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            //handling special edge case.
            if(mid == 0){
                mid = 1;
            }
            else if(mid == arr.length - 1){
                mid = arr.length - 2;
            }
            
            boolean isMidGreaterThanPrev = arr[mid] > arr[mid-1];
            boolean isMidGreaterThanNext = arr[mid] > arr[mid+1];

            if(isMidGreaterThanNext && isMidGreaterThanPrev){
                ans = mid;
                break;
            }
            else if(isMidGreaterThanPrev){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

        return ans;
    }    
}
