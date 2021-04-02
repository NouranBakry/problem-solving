/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        int maxDepth = findDepth(root);
        return findSum(root, maxDepth, 1);
    }

    public int findDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(findDepth(root.left), findDepth(root.right)) + 1;
    }

    public int findSum(TreeNode root, int maxDepth, int depth) {
        if (depth == 0) {
            return 0;
        }
        if (root == null) {
            return 0;
        }
        if (depth == maxDepth) {
            return root.val;
        }
        return findSum(root.left, maxDepth, depth + 1) + findSum(root.right, maxDepth, depth + 1);
    }
}