/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
// DFS using a stack
/**
 * use Array Dequeue in java instead of stack 
 * Deque<TreeNode> stack = new ArrayDeque<>()
 * Both implementations here are iterative. There is a recursive apporach for both algorithms 
 * Space Complexity is O(n)
 * Time Complexity is O(n)
 */
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = cloned;
        stack.push(current);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.val == target.val) {
                return node;
            }
            stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return current;
    }
}

// BFS using a queue 
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode current = cloned;
        queue.add(current);
        while (!queue.isEmpty()) {
            TreeNode node = queue.peek();
            if (node.val == target.val) {
                return node;
            }
            queue.remove();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return current;
    }
}
