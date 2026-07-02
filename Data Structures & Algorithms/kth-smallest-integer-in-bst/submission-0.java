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
    public int kthSmallest(TreeNode root, int k) {
        /*
        Argument to be made to do just an inorder traversal and keep a count
        when count == k just return the current node we are on

        can we do this better?
        This is technically linear as the max value takes us the traversing the whole tree

        the tree is sorted so we should be able to leverage its log n property

        the thing is we don't know the size of the tree
        so when we say k = 4 for  [4,3,5,2,null]
        we don't know that we should go right 
        */

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(--k == 0) return curr.val;
            curr = curr.right;
        }
        return -1;
    }
}
