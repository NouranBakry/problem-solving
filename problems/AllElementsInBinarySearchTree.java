/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
/**
 * Space Complexity O(m) + O(n)
 * Time Complexity O(m) + O(n), sorting takes log(m+n)
 * O(m)+O(n) + O(m+nlog(m+n))
 * so running time -> O(m + n Log(m+n))
 * The solution below is using bfs to traverse through trees and add each item in a list, merge two lists and then sort the large list
 * if we traverse each tree using in-order traversal, each list will be sorted, then we merge both lists into one large list
 */
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> output = new ArrayList();
        List<Integer> list1 = new ArrayList();
        List<Integer> list2 = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        if (root1 != null) {
            queue.add(root1);
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                list1.add(node.val);
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        if (root2 != null) {
            queue.add(root2);
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                list2.add(node.val);
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        output.addAll(list1);
        output.addAll(list2);
        Collections.sort(output);
        return output;
    }
}

// another solution using dfs, stack and in-order traversal
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack(), stack2 = new Stack();
        List<Integer> result = new ArrayList();
        while (root1 != null || root2 != null || !stack1.empty() || !stack2.empty()) {
            while (root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            }
            while (root2 != null) {
                stack2.push(root2);
                root2 = root2.left;
            }
            if (stack2.empty() || (!stack1.empty() && satck1.peek().val <= stack2.peek().val)) {
                root1 = stack1.pop();
                result.add(root1.val);
                root1 = root1.right;
            } else {
                root2 = stack2.pop();
                result.add(root2.val);
                root2 = root2.right;
            }
        }
        return result;
    }
}
