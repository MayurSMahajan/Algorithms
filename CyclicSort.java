import java.util.*;

/**
 * CyclicSort
 */
public class CyclicSort {
    public static void main(String[] args) {
        BasicCyclicSort bsc = new BasicCyclicSort();
        int[] arr = { 4, 3, 2, 7, 8, 2, 3, 1 };
        // int[] nums = { 3, 4, 5, 1, 2 };
        System.out.println(Arrays.toString(bsc.sort(arr)));
        List<Integer> list = bsc.findDuplicates(arr);
        for (Integer element : list) {
        System.out.println(element);
        }

    }
}

/**
 * BasicCyclicSort - Only works for a continous range of 1 to N elements of an
 * array.
 */
class BasicCyclicSort {
    int[] sort(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;

            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }

        }
        return nums;
    }

    void swap(int[] nums, int i, int correct) {
        int temp = nums[i];
        nums[i] = nums[correct];
        nums[correct] = temp;

    }

    // Problem :
    // https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
    // Asked in Google Interview.
    List<Integer> findDisappearedNumbers(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;

            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }

        }

        List<Integer> intList = new ArrayList<Integer>(nums.length);
        for (int index = 0; index < nums.length; index++) {
            if (index + 1 != nums[index]) {
                intList.add(index + 1);
            }
        }

        return intList;
    }

    // Problems :
    // https://leetcode.com/problems/find-all-duplicates-in-an-array/submissions/
    // Asked in Amazon and Microsoft Interview 
    List<Integer> findDuplicates(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;

            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }

        }

        List<Integer> intList = new ArrayList<Integer>(nums.length);
        for (int index = 0; index < nums.length; index++) {
            if (index + 1 != nums[index]) {
                intList.add(nums[index]);
            }
        }

        return intList;
    }

    //LeetCode : https://leetcode.com/problems/find-the-duplicate-number/
    //Microsoft
    int findDuplicate(int[] nums){
        int i = 0;
        while (i<nums.length) {
            int correct = nums[i] - 1;

            if(nums[i] != nums[correct]){
                swap(nums, i, correct);
            }
            else{
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if(j + 1 != nums[j]){
                return nums[j];
            }
        }
        return -1;
    }

    
}