/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
*/

class Solution {
    public Node connect(Node root) {
        /*
        This is just bfs 
        like literally

        bfs the tree from the root
        the next node in order for traversal is just the .right recepient

        the real edge case is how do we know when it goes null?

        we can track height of the tree via bfs
        if the height differs for the next node its null
        */        
        if(root == null) { return null; }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        // Start the level traversal
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node node = queue.poll();
                if(i < size - 1) {
                    node.next = queue.peek();
                }
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }  
        return root;
    }
}