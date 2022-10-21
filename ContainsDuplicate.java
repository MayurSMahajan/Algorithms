import java.util.Arrays;
import java.util.HashSet;

/**
 * ContainsDuplicate -- Problem Series LeetCode
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        CD cd = new CD();
        System.out.println(cd.containsDuplicateI(nums));
        System.out.println(cd.containsDuplicateUsingSet(nums));
    }
}

class CD{
    
    //https://leetcode.com/problems/contains-duplicate/
    
    //Time Complexity : O(n logn) bcz sort()'s complexity is O(n log n)
    public boolean containsDuplicateI(int[] nums) {
        if(nums.length == 1) return false;
        
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        
        while(j<nums.length){
            if(nums[i] == nums[j]){
                return true;
            }
            i++;
            j++;
        }
        
        return false;
    }

    //This is more optimized. A hashset can't contain duplicate values
    //We check if some value exists in the hashset, if yes then we have duplicates
    //if no then there are no duplicates and hence we add that element in the set
    //Time Complexity : O(n)
    public boolean containsDuplicateUsingSet(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}