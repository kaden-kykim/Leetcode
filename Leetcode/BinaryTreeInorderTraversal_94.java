import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        helper(result, root);
        return result;
    }

    private void helper(List<Integer> result, TreeNode root) {
        if (root.left != null) helper(result, root.left);
        result.add(root.val);
        if (root.right != null) helper(result, root.right);
    }

    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curNode;
        while (!stack.isEmpty()) {
            curNode = stack.peek();
            if (curNode.left != null) { stack.push(curNode.left); curNode.left = null; }
            else {
                stack.pop(); result.add(curNode.val);
                if (curNode.right != null) stack.push(curNode.right);
            }
        }
        return result;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
