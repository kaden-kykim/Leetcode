public class MaximumDepthOfBinaryTree_104 {

    public int maxDepth(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode node, int depth) {
        if (node == null) return depth;
        return Math.max(helper(node.left, ++depth), helper(node.right, depth));
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
