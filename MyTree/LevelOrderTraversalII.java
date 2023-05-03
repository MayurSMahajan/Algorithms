// 107. Binary Tree Level Order Traversal II
// https://leetcode.com/problems/binary-tree-level-order-traversal-ii
// faster than 93% submissions and 68% memory efficient

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //we will do level order traversal and then simply 
        //reverse our answer.
        List<List<Integer>> ans = bfs(root);
        Collections.reverse(ans);
        return ans;
    }

    List<List<Integer>> bfs(TreeNode root){
        
        List<List<Integer>> ans = new ArrayList();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        List<Integer> rootList = new ArrayList<Integer>();
        rootList.add(root.val);
        ans.add(rootList);

        while(!q.isEmpty()){
            int cap = q.size();
            List<Integer> levelList = new ArrayList<Integer>();
            for(int i=0; i<cap;i++){
                TreeNode n = q.remove();
                if(n.left != null){
                    q.add(n.left);
                    levelList.add(n.left.val);
                }
                if(n.right != null){
                    q.add(n.right);
                    levelList.add(n.right.val);
                }
            }
            if(levelList.size() != 0){
                ans.add(levelList);
            }
        }
        return ans;
    }
    
    
}