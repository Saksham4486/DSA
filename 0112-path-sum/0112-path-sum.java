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
    public static boolean sum(TreeNode root,int target,int current)
    {   if(root==null)
    return false;
    current+=root.val;
        if(root.left==null&&root.right==null)
        return current==target;
        return sum(root.left,target,current)||sum(root.right,target,current);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int currsum=0;
        if(root==null)
        return false;
        return sum(root,targetSum,0);
    }
}