/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return maxPathSum;
    }

    private int pathSum(TreeNode root){
        if(root==null) return 0;

        int leftPathSum=Math.max(pathSum(root.left),0);
        int rightPathSum=Math.max(pathSum(root.right),0);

        maxPathSum=Math.max(maxPathSum,leftPathSum+rightPathSum+root.val);
        
        return Math.max(leftPathSum,rightPathSum)+root.val;
    }
}