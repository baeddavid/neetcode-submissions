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
    public boolean isValidBST(TreeNode root) {
        /*
        We work our way up from the bottom of the tree

        A leaf is considered a valid bst
        So for a tree to be considered a valid bst all its subtrees must be valid
        but there is a caveat

        we need to pass the ancestors values down as boundaries

        for example take 
             2
            / \
           1   3

        This is valid 
        however if the tree is 

             2
            / \
           1   3
            \
             5
        this is invalid
        why?
        although 1 -> 5 is valid it breaks the tree as 5 is in the left subtree
        so we must pass ancestor values down as boundaries
        */
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean valid(TreeNode node, long low, long high) {
        if(node == null) return true;
        if(node.val <= low || node.val >= high) {
            return false;
        }
        return valid(node.left, low, node.val) && valid(node.right, node.val, high);
    }
}
