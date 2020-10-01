 // in order traversal 
 // left, root, right
 // test 
 // Input: root = [1,null,2]
// Output: [1,2]

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
// iterative 
// Complexity O(n)
// Space O(n)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        TreeNode currentNode = root;
        Stack<TreeNode> stack = new Stack<>();
        while(currentNode!=null ||!stack.isEmpty()){
            while(currentNode!=null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();  
            inOrder.add(currentNode.val);
            currentNode = currentNode.right;
        }
        return inOrder;
    }
}

// Recursive 
// Space Complexity worst case O(n) Avg case O(log n)
// Complexity O(n)

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        inOrderRecursion(root, inOrder);
        return inOrder;
    }

    private void inOrderRecursion(TreeNode root, List<Integer> inOrderList) {
        if (root != null) {
            if (root.left != null) {
                inOrderRecursion(root.left, inOrderList);
            }
            inOrderList.add(root.val);
            if (root.right != null) {
                inOrderRecursion(root.right, inOrderList);
            }
        }
    }
}