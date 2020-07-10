import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal_103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return helper(root, 0, new ArrayList<>());
    }

    private List<List<Integer>> helper(TreeNode root, int depth, List<List<Integer>> result) {
        if (root == null) return result;
        List<Integer> list;
        if (result.size() <= depth) { list = new ArrayList<>(); result.add(list); }
        else list = result.get(depth);
        if (depth % 2 == 0) list.add(root.val);
        else list.add(0, root.val);
        helper(root.left, depth + 1, result);
        helper(root.right, depth + 1, result);
        return result;
    }

    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.add(root);
        helper2(stack, 0, result);
        return result;
    }

    private void helper2(Stack<TreeNode> parents, int depth, List<List<Integer>> result) {
        if (parents.isEmpty()) return;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> level = new ArrayList<>(parents.size());
        while (!parents.isEmpty()) {
            TreeNode node = parents.pop();
            level.add(node.val);
            if (depth % 2 == 0) {
                if (node.left != null) stack.add(node.left);
                if (node.right != null) stack.add(node.right);
            } else {
                if (node.right != null) stack.add(node.right);
                if (node.left != null) stack.add(node.left);
            }
        }
        result.add(level);
        helper2(stack, depth + 1, result);
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
