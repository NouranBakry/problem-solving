//Recursive
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);

        root.left = right;
        root.right = left;

        return root;
    }
}

// Iterative
class Solution {
    public TreeNode invertBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.right;
            current.right = current.left;
            current.left = temp;
            if (current.right != null)
                queue.add(current.right);
            if (current.left != null)
                queue.add(current.left);
        }
        return root;
    }
}
