import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;
import java.lang.Math;

/**
 * ContainsDuplicate -- Problem Series LeetCode
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        CD cd = new CD();
        System.out.println(cd.containsDuplicateI(nums));
        System.out.println(cd.containsDuplicateUsingSet(nums));
        System.out.println(cd.containsNearbyDuplicate(nums, 6));
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

    //https://leetcode.com/problems/contains-duplicate-ii/
    //Time Limit Exceeded

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k > nums.length){
            k = nums.length;
        }
        while (k > 0) {
            int i = 0;
            int j = i + k;
            while (j < nums.length) {
                if(nums[i] == nums[j]){
                    return true;
                }
                i++;
                j++;
            }
            k--;
        }
        return false;   
    }

    //https://leetcode.com/problems/contains-duplicate-ii/
    //17sec faster than 97.65%, 50MB less space than 92.12%

    public boolean containsNearbyDuplicateUsingHash(int[] nums, int k){
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i=0; i < nums.length; i++){
            //if a number already exists in the hashmap
            
            if(map.get(nums[i]) != null){
                Integer indexOfFound = map.get(nums[i]);
                if(k >= Math.abs(i - indexOfFound)){
                    return true;
                }
            }
            map.put(nums[i], i);
        
        }

        return false;
    }
}