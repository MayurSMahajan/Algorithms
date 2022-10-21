import java.util.Arrays;

/**
 * ContainsDuplicate -- Problem Series LeetCode
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        CD cd = new CD();
        System.out.println(cd.containsDuplicateI(nums));
    }
}

class CD{
    
    //https://leetcode.com/problems/contains-duplicate/
    
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
}