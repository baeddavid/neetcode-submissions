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
    public List<Integer> rightSideView(TreeNode root) {
        /*
        This is a level order traversal bfs style
        We can leverage a queue for this
        The real issue here is that the traditional queue based level order traversal
        does not acually know when we're at the end of the level

        this is due to how we add
        TreeNode curr = q.poll();
        if(curr.left != null) q.offer(curr.left);
        if(curr.right != null) q.offer(curr.right);

        It immedately transacts the next level under it so it's not simple as oh just
        return the end of the queue

        We can't use level order size because children can be null this is not a balanced
        tree 

        We also can't just return curr.right in a while loop because if the right child is null
        and the left child exists then we must return the left child

        but wait if the right child is null...
        then there is no right subtree

        maybe we can go right all the way down
        and when we encounter a right null child
        then we check the left subtree and use that as the new recursive right all the way 
        down 
        */        
        
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) { return res; }
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if(i == size - 1) {
                    res.add(curr.val);
                }
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
        } 
        return res;
    }
}
