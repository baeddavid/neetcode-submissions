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
    public int rob(TreeNode root) {
        /*
        This is an interesting problem
        Almost fell for the bait where you reach for can't rob two levels in a row but you can
        they just can't be direct descendants

        but you can rob two children of a node and be safe since they are not connected
        this would imply a bfs

        We need to know a node's parent
        because if we rob a node we then need to pass on information to the children node that we 
        can't rob it

        i initially thought we don't push the children nodes if we rob the parent but that is 
        not right as we need the chldren nodes for the rest of the tree
        */
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode node) {
        if(node == null) return new int[] { 0, 0 };
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int rob = node.val + left[1] + right[1];
        int skip = Math.max(left[0], left[1])
            + Math.max(right[0], right[1]);

        return new int[] { rob, skip };
    }
}