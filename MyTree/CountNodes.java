//https://leetcode.com/problems/count-complete-tree-nodes/
//I can't believe how this is a medium problem.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        int count = 0;
        return cndfs(root, count);
    }
    
    public int cndfs(TreeNode root, int count){
        
        if(root == null) return 0;
        count = cndfs(root.left, count) + cndfs(root.right, count);
        return count + 1; 
    }
}

// I am not going to write the driver code for this, its too simple.
