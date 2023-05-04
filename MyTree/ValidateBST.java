// 98. Validate Binary Search Tree
// https://leetcode.com/problems/validate-binary-search-tree
// Faster than 100% and 37% memory efficient

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
    public boolean isValidBST(TreeNode root) {
        return validateBST(root, null, null);
    }

    boolean validateBST(TreeNode root, TreeNode alpha, TreeNode beta){
        if(root == null) return true;
        if(alpha != null && root.val <= alpha.val) return false;
        if(beta != null && root.val >= beta.val) return false;
        return (validateBST(root.left, alpha, root) && validateBST(root.right, root, beta));
    }
}