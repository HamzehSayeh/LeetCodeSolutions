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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return parentNode(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode parentNode(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);

        int inorderIndex = findFirstOccurrence(inorder, preorder[preStart]);

        int leftSize = inorderIndex - inStart;

        root.left = parentNode(preorder, inorder, preStart + 1, preStart + leftSize, inStart, inorderIndex - 1);
        root.right = parentNode(preorder, inorder, preStart + leftSize + 1, preEnd, inorderIndex + 1, inEnd);
        return root;
    }

    public static int findFirstOccurrence(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1; // not found
    }
}