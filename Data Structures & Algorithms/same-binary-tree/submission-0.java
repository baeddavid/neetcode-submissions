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
    private boolean isMatch = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        inorder(p, q);
        return isMatch;
    }

    private void inorder(TreeNode a, TreeNode b) {
        if((a == null && b!= null) || a != null && b == null) isMatch = false;

        if(a != null && b != null) {
            if(a.val != b.val) isMatch = false;
            inorder(a.left, b.left);
            inorder(a.right, b.right);
        }
    }
}
