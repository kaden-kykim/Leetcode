import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FlattenBinaryTreeToLinkedList_114 {

    private final List<TreeNode> list = new ArrayList<>();

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) root = root.right;
        root.right = right;
    }

    public void flatten1(TreeNode root) {
        helper(root);
        for (int i = 0; i < list.size() - 1; ++i) list.get(i).right = list.get(i + 1);
    }

    private void helper(TreeNode node) {
        if (node == null) return;
        list.add(node);
        helper(node.left);
        helper(node.right);
        node.left = null;
    }

    public void flatten2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
            node.left = null;
            node.right = stack.isEmpty() ? null : stack.peek();
        }
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
