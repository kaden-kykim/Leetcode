public class BinaryTreeMaximumPathSum_124 {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int lVal = Math.max(helper(root.left), 0);
        int rVal = Math.max(helper(root.right), 0);
        max = Math.max(max, root.val + lVal + rVal);
        return root.val + Math.max(lVal, rVal);
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
