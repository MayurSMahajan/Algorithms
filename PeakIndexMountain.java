public class PeakIndexMountain {
    public static void main(String[] args) {
        PIMII pim = new PIMII();
        int[] arr = {3,5,3,2,0};
        System.out.println(pim.peakIndexInMountainArray(arr));
    }
}

//Leetcode 852
//https://leetcode.com/problems/peak-index-in-a-mountain-array/

class PIMII {
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

//LeetCode 162
//https://leetcode.com/problems/find-peak-element/

class PIMI {
    public int findPeakElement(int[] arr) {
        int ans = 0;
        
        if(arr.length == 1){
            return 0;
        }
        if(arr.length == 2){
            return arr[0] > arr[1] ? 0 : 1;
        }

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int prev;
            int next;

            //handling special edge case.
            if(mid == 0){
                if(arr[mid] > arr[mid+1]){
                    return 0;
                }
                else{
                    prev = Integer.MIN_VALUE;
                }
            }
            else{
                prev = arr[mid-1];
            }
            
            if(mid == arr.length - 1){
                if(arr[mid] > arr[mid-1]){
                    return mid;
                }
                else{
                    next = Integer.MIN_VALUE;
                }
            }
            else{
                next = arr[mid+1];
            }
            
            
            boolean isMidGreaterThanPrev = arr[mid] > prev;
            boolean isMidGreaterThanNext = arr[mid] > next;

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
