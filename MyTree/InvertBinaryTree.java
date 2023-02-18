/**
  https://leetcode.com/problems/invert-binary-tree
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
class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        return  invertNodeChilds(root);
    }

    private TreeNode invertNodeChilds(TreeNode node){
        if(node == null || (node.left == null && node.right == null)) return node;
        TreeNode temp = node.right;
        node.right = node.left;
        node.left = temp;
        node.right = invertNodeChilds(node.right);
        node.left = invertNodeChilds(node.left);
        return node;
    }
}
