//https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
//Amazon Question.
//Since we can't code an infinite array,
//we will try to mimic an infinite arr by refusing to use arr.length 
//thus we don't know the size of the array.

public class SearchInInfiniteArr {
    public static void main(String[] args) {
        InfiniteSearch ifs = new InfiniteSearch();

        // int[] nums = {1,2,3,4,5,5,6,7,8,9,10,11,14,15,16,17,19,21,26,36,37,38,39,50};
        // System.out.println(ifs.searchInInfiniteArr(nums, 13));

        int[] nums = {1,2,3,4,5,5,6,7,8,9,10,11,14,15,16,17,19,21,26,36,37,38,39,50};
        System.out.println(ifs.searchInInfiniteArr(nums, 14));

        // int[] nums = {1,2,3,4,5,5,6,7,8,9,10,11,14,15,16,17,19,21,26,36,37,38,39,50};
        // System.out.println(ifs.searchInInfiniteArr(nums, 37));
        //The above code will cause an exception because it will assign end to be more than
        // the physical size of the array, but in truth since we are looking at infinite arr
        // this exception will never occur in the ideal world.
        
    }
}

class InfiniteSearch {

    public int searchInInfiniteArr(int[] nums, int target){
        //so our approach is simple, we will work with subarrays
        //bcz in any kind of search we must have the length of arr, be it linear or binary search.
        //so we will take a subset from the original array and then apply binary search
        //since this array is sorted.

        //To pick the subarrays we will use the sliding window concept.
        //We can have a fixed sliding window, but even faster sol is to use a ever growing window
        boolean notGotResult = true;
        
        int start = 0;
        int end = 1;
        int windowSize = 4;
        int result = -1;
        int count = 1;
        
        while (notGotResult) {  
            System.out.println("This function runs "+ count++);
            if(nums[start] < target){
                result = binarySearch(nums, target, start, end);
                if(result != -1){
                    notGotResult = false;
                }
                start = end + 1;
                end = start + windowSize;
                windowSize *= 2;
            }  
            else{
                notGotResult = false;
            }
        }

        return result;
    }

    public int binarySearch(int arr[], int element, int start, int end){

        while (start <= end) {
            int middle = (start + end) / 2;

            if(arr[middle] == element){
                return middle;
            }
            else if(arr[middle] < element){
                start = middle + 1;
            }
            else{
                end = middle - 1;
            }
        }

        return -1;
    }
    
}
