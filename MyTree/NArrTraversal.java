package MyTree;

import java.util.ArrayList;
import java.util.List;

//LeetCode 590
//https://leetcode.com/problems/n-ary-tree-postorder-traversal/submissions/

//Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class NArrTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> visited = new ArrayList<Integer>();
        postorderRecursive(root, visited);
        return visited;
    }
    
    public void postorderRecursive(Node node, List<Integer> visited){
        if(node == null) return;
        for(Node n : node.children){
            postorderRecursive(n,visited);
        }
        visited.add(node.val);
    }
}




