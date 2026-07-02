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

    private int best = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        /*
        Oh this is interesting
        Instead of the usual tree problem where it asks us to traverse down etc we can go sideways
        our goal is to find the maximum path through a tree

        this is more like a graph problem 

        Traverseing the tree left to right is just
        traverse left side of the root and right side of the root

        the thing is we cant retraverse a path
        so if both childs are candidates for the sum then they must go left to right
        not root then left then root then right

        this is a graph problem through and through where we are not allowed to revisit an
        already visited node

        It's not directed but we need to track visited nodes

        Essentially when we take a node this is similar to previous dp problems like house robber
        does taking this node as part of the sum increase our sum or not?

        so we must consider taking vs not taking


        */

        dfs(root);
        return best;
    }

    private int dfs(TreeNode root) {
        if(root == null) return 0;

        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        best = Math.max(best, left + root.val + right);

        return root.val + Math.max(left, right);
    }
}
