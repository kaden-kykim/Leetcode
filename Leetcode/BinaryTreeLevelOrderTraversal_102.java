import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        return helper(root, 0, new ArrayList<>());
    }

    private List<List<Integer>> helper(TreeNode root, int depth, List<List<Integer>> result) {
        if (root == null) return result;
        List<Integer> list;
        if (result.size() <= depth){ list = new ArrayList<>(); result.add(list); }
        else list = result.get(depth);
        list.add(root.val);
        result = helper(root.left, depth + 1, result);
        result = helper(root.right, depth + 1, result);
        return result;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        helper1(queue, result);
        return result;
    }

    private void helper1(Queue<TreeNode> parents, List<List<Integer>> result) {
        if (parents.isEmpty()) return;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> level = new ArrayList<>(parents.size());
        while (!parents.isEmpty()) {
            TreeNode node = parents.poll();
            level.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        result.add(level);
        helper1(queue, result);
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
