package MyTree;

// 654. https://leetcode.com/problems/maximum-binary-tree/
public class MaxBinaryTree {
    //Again I am too lazy to code the driving program. Both the solutions described below
    // work fine, try them directly in LeetCode IDE.
}

/**
 * My Initial Solution
 */
class InitialMaxBT {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0) return null;
        int indexWithMax = findIndexWithMaxValue(nums);
        TreeNode n = new TreeNode(nums[indexWithMax]);
        
        int start = 0;
        int end = indexWithMax;
        
        if(start != end){
            n.left = constructMaximumBinaryTree(subArr(nums, start, end));
        }
        else{
            n.left = null;
        }
        
        start = indexWithMax + 1;
        end = nums.length;
        
        if(start != end){
            n.right = constructMaximumBinaryTree(subArr(nums, start, end));    
        }else{
            n.right = null;
        }
            
        return n;
    }
    
    public int[] subArr(int[] nums, int start, int end){
        
        if(nums.length == 0){
            return new int[0];
        }
        int[] subarr = new int[end - start];
        
        int j = 0;
        for(int i = start; i < end; i++){
            subarr[j++] = nums[i];
        }
        return subarr;
    }
    
    public int findIndexWithMaxValue(int[] nums){
        int indexOfMax = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > nums[indexOfMax]){
                indexOfMax = i;
            }
        }
        return indexOfMax;
    }
}
//The algorithm is correct but the solution is slow because of the way we are creating
// our subarray. The following is a much cleaner way to achieve the same algorithm.

class OptimizedMaxBt {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaxBT(nums, 0, nums.length);
    }
    
    public TreeNode constructMaxBT(int[] nums, int start, int end){
        if(start == end){
            return null;
        }
        int indexWithMax = findIndexWithMaxValue(nums, start, end);
        TreeNode n = new TreeNode(nums[indexWithMax]);
        n.left = constructMaxBT(nums, start, indexWithMax);
        n.right = constructMaxBT(nums, indexWithMax + 1, end);
        return n;
    }
    
    public int findIndexWithMaxValue(int[] nums, int start, int end){
        int indexOfMax = start;
        for(int i = start; i < end; i++){
            if(nums[i] > nums[indexOfMax]){
                indexOfMax = i;
            }
        }
        return indexOfMax;
    }    
}
