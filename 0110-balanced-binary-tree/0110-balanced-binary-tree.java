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
    public  static int height(TreeNode root)
    {
        if(root==null)
        return 0;
        int left=0,right=0;
        left=height(root.left);
        right=height(root.right);
        return Math.max(left,right)+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null)
        return true;
        int result=Math.abs(height(root.left)-height(root.right));
        if(result>1)
        return false;
        return isBalanced(root.left)&&isBalanced(root.right);
    }
}