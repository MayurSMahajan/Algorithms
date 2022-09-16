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

//Not a part of leetcode problem, but I thought it will be nice if I could also implement
//the other two ways to traverse the tree.

//Actually I found a leetcode problem that requires preorder traversal, and the following 
//algorithm just aces it, being 100% faster.
//https://leetcode.com/problems/binary-tree-preorder-traversal/
class PreOrderTraversal{
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> visited = new ArrayList<Integer>();
        preorderTraverse(root,visited);
        return visited;
    }

    public void preorderTraverse(TreeNode node, List<Integer> visited){
        if (node == null) return;
        visited.add(node.val);
        preorderTraverse(node.left, visited);
        preorderTraverse(node.right, visited);
    }
}

//And here's one more!

class PostOrderTraversal{
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> visited = new ArrayList<Integer>();
        postorderTraverse(root,visited);
        return visited;
    }

    public void postorderTraverse(TreeNode node, List<Integer> visited){
        if(node == null) return;
        postorderTraverse(node.left,visited);
        postorderTraverse(node.right,visited);
        visited.add(node.val);
    }
}
