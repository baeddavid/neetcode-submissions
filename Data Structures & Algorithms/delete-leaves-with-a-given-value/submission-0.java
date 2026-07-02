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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        /*
        Uh we need to delete all leaf nodes which means any node that doesn't have children

        again no parent node so we will need to check via 
        node.left.left == null && node.left.right == null && node.left.val == target
        if this is true then it's node.left = false

        we can just dfs this

        or or

        since we're doing leafs 

        bfs

        go level by level checking for leafs

        bfs probably makes the most sense i think
        */

        if(root == null) return null;
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if(root.left == null && root.right == null && root.val == target) return null;

        return root;
    }
}