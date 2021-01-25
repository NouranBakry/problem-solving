/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        int max = Integer.MIN_VALUE, maxLevel = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;
        // BFS
        while (!q.isEmpty()) {
            int sum = 0;
            // looping on size of q
            int i = q.size();
            while (i > 0) {
                TreeNode n = q.poll();
                sum += n.val;
                if (n.left != null) {
                    q.offer(n.left);
                }
                if (n.right != null) {
                    q.offer(n.right);
                }
                --i;
            }
            if (sum > max) {
                max = sum;
                maxLevel = level;
            }
            level++;
        }
        return maxLevel;
    }

}