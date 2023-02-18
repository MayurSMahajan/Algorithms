/**
   https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/
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
class ReverseOddLevelsOfBT {

    public TreeNode reverseOddLevels(TreeNode root) {
        invertChildNodes(root.left, root.right, 1);
        return root;
    }

    private void invertChildNodes(TreeNode left, TreeNode right, int level) {
        if(left == null && right == null) return;
        //level is odd
        if(level%2 != 0){
            int temp = right.val;
            right.val = left.val;
            left.val = temp;
        }
        invertChildNodes(left.left, right.right, level+1);
        invertChildNodes(left.right, right.left, level+1);
    }
}
