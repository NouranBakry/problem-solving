/**
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 */

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
/**
 Solution:
 Iterative in order traversal
 Time Complexity 
 O(H+K) where H is the height of the tree
 Space Complexity 
 O(H)
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0){
                return root.val;
            }
            root = root.right;
        }
     }
}