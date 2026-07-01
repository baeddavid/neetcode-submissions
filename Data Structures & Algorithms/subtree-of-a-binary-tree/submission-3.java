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
    public boolean isSubtree(TreeNode root, TreeNode subroot) {
        /*
        We do a tree matching algorithm only if the root matches
        */
        if(root == null) return subroot == null;
        if(inorder(root, subroot)) return true;
        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }

    private boolean inorder(TreeNode root, TreeNode sub) {
        if(root == null && sub == null) return true;
        if(root == null || sub == null) return false;
        return root.val == sub.val && inorder(root.left, sub.left) && inorder(root.right, sub.right);
    }
}
