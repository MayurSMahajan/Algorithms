// 133. Clone Graph
// https://leetcode.com/problems/clone-graph
// 99% faster only takes 24ms, 49% memory efficient

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node, Node> map = new HashMap<Node,Node>();
        return dfs(node, map);
    }

    Node dfs(Node node, HashMap<Node, Node> map){
        if(map.containsKey(node)) return map.get(node);

        int value = node.val;
        Node copy = new Node(value);

        map.put(node,copy);

        for(Node n : node.neighbors){
            copy.neighbors.add(dfs(n, map));
        }

        return copy;
    }
}
