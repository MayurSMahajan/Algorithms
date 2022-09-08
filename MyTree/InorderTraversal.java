package MyTree;
import java.util.*;

// 94. https://leetcode.com/problems/binary-tree-inorder-traversal/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> visited = new ArrayList<Integer>();
        inorderTraverse(root, visited);
        return visited;
        
    }
    public void inorderTraverse(TreeNode node, List<Integer> visited){
        if(node == null) return;
        inorderTraverse(node.left, visited);
        visited.add(node.val);
        inorderTraverse(node.right, visited);
        
    }
}

//execute directly in leetcode ide since I have not implemented the main method to call
//these functions.


 
