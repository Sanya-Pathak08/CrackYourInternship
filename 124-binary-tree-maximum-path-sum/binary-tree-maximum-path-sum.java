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
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // max sum on the left and right subtree of node
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // the value of the current node plus maximum path sum of the left and right subtrees
        int priceNewpath = node.val + leftGain + rightGain;

        // update maxSum if it's less than priceNewpath
        maxSum = Math.max(maxSum, priceNewpath);

        // return the max gain if the node is added to the path
        return node.val + Math.max(leftGain, rightGain);
    }
}