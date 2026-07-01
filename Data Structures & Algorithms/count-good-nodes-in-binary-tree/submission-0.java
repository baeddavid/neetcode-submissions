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
    public int goodNodes(TreeNode root) {
        /*
        Ah so it's on a per node basis

        The root will always be considered good because it has no parents 
        A node is considered a good node when no node on that path from the root to that node contains no nodes with a value greater than the value at the node 
        we are considering

        This is again interesting
        this is a normal binary tree so there's no order to it

        So we need context for each node essentially

        oh we can track max value seen so far on a path as we traverse the tree and update it accordingly
        if the value at curr node x > max seen so far it's a good node

        else than its whatever

        How do we track the current max so far on the path

        recursion handles it

        inorder traversal
        update max which at that recursive level keeps track of the local path max

        Oh no it's preorder traversal
        we are doing the work here
        */        

        return count(root, Integer. MIN_VALUE);
    }

    private int count(TreeNode node, int maxSoFar) {
        if (node == null) { return 0; }
        int goodNode = node.val >= maxSoFar ? 1 : 0;
        int newMax = Math.max(maxSoFar, node.val);

        return goodNode + count(node.left, newMax) + count(node.right, newMax);
    }
}
