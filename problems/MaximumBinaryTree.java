/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
/**
 * Time complexity : O(n^2)O(n 2 ). The function construct is called nn times.
 * At each level of the recursive tree, we traverse over all the nn elements to
 * find the maximum element. In the average case, there will be a \log nlogn
 * levels leading to a complexity of O\big(n\log n\big)O(nlogn). In the worst
 * case, the depth of the recursive tree can grow upto nn, which happens in the
 * case of a sorted numsnums array, giving a complexity of O(n^2)O(n 2 ).
 * 
 * Space complexity : O(n)O(n). The size of the setset can grow upto nn in the
 * worst case. In the average case, the size will be \log nlogn for nn elements
 * in numsnums, giving an average case complexity of O(\log n)O(logn)
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return createTree(nums, 0, nums.length);
    }

    public int getMaxIndex(int[] nums, int left, int right) {
        int maxIndex = left;
        int maxVal = 0;
        for (int i = left; i < right; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public TreeNode createTree(int[] nums, int left, int right) {
        if (left == right) {
            return null;
        }
        int maxIndex = getMaxIndex(nums, left, right);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.right = createTree(nums, maxIndex + 1, right);
        root.left = createTree(nums, left, maxIndex);
        return root;
    }
}