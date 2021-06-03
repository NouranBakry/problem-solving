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
// dfs
/**this solution is missing a case where the height of the left branch is longer so that way we will need to traverse and get that node from the left tree */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        result.add(root.val);
        if(root.right == null && root.left == null){
            return result;
        } else if(root.right!=null){
            stack.push(root.right);
        } else{
            stack.push(root.left);
        }
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            result.add(current.val);
            if(current.right != null){
                stack.push(current.right);
            }else if(current.left != null) {
                stack.push(current.left);
            }
        }
        return result;
    }
}

/** Solution using recursion check
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList list = new ArrayList();
        rightSideView(root, 0, list);
        return list;
    }
    
    public void rightSideView(TreeNode root, int level, ArrayList list) {
        if(root == null) return;

        if(list.size() == level)
            list.add(root.val);

        rightSideView(root.right, level + 1, list);
        rightSideView(root.left, level + 1, list);
    }
}

/** Using bfs seems maybe more intuitive because  we need to keep track of each level and if there are no right nodes we will consider the left nodes*/
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(q.size()>0){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node= q.poll();
                if(i==size-1) // last one is right most one.
                    result.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
        }
        return result;
    }
}