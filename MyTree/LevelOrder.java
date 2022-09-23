package MyTree;
import java.util.*;

//102. https://leetcode.com/problems/binary-tree-level-order-traversal/

public class LevelOrder {
    public static void main(String[] args) {
        //I am too lazy to write the stub to call the function below.
        //Try it on leetcode itself.        
    }
}
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
class InnerLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> visited = new ArrayList<List<Integer>>();
        if(root == null) return visited;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        
        while(!q.isEmpty()){
            int qLength = q.size();
            List<Integer> subArr = new ArrayList<Integer>();
            
            for(int i = 0; i < qLength; i++){
                TreeNode curr = q.remove();
                if(curr != null){
                    subArr.add(curr.val);
                    if(curr.left != null){
                        q.add(curr.left);    
                    }
                    if(curr.right != null){
                        q.add(curr.right);    
                    }
                    
                }    
            }
            visited.add(subArr);
        }
        
        return visited;
    }
    
}