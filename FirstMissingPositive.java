//Hint : Solved using Cyclic Sort.
public class FirstMissingPositive {
    public static void main(String[] args) {
        FMP fmp = new FMP();
        int[] arr1 = { 3, 4, -1, 1, 0 };
        int[] arr2 = { 1,2,0 };
        int[] arr3 = { 1,1 };
        int[] arr4 = { 1 };
        
        System.out.println(fmp.firstMissingPositive(arr1));
        System.out.println(fmp.firstMissingPositive(arr2));
        System.out.println(fmp.firstMissingPositive(arr3));
        System.out.println(fmp.firstMissingPositive(arr4));
    }
}

/*
 * https://leetcode.com/problems/first-missing-positive/
 * LeetCode - Hard | Amazon
 */
class FMP {

    public int firstMissingPositive(int[] nums) {
        //Basically sort the array using cyclic sort and ignore non positive and large numbers
        //By large numbers I mean numbers who are greater then nums.length
        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= 0 || nums[i] > nums.length) { //ignoring numbers.
                i++;
            } else {

                int correct = nums[i] - 1; // the position where the number actually belongs.

                if (nums[i] != nums[correct]) {
                    swap(nums, i, correct); //swap if the intended position doesn't have the intended number.
                } else {
                    i++;
                }
            }

        }

        //now we have a sorted array with the smallest positive numbers at the start
        //now we will simply loop from index 1 and check if 1 exists at index 0
        //if it does then go to next number and so on.
        int index = 0;
        while(index < nums.length){
            if(nums[index] != index + 1){
                return index + 1;
            }
            else{
                index++;
            }
        }
        return nums[index - 1] + 1;
    }

    //basic swap utility function.
    void swap(int[] nums, int i, int correct) {
        int temp = nums[i];
        nums[i] = nums[correct];
        nums[correct] = temp;
    }
}
