public class KthSmallestElementInABST_230 {

    private int count = 0;
    private int kSmallestValue = 0;

    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return kSmallestValue;
    }

    private void helper(TreeNode node, int k) {
        if (node == null || count > k) return;
        helper(node.left, k);
        if (++count == k) { kSmallestValue = node.val; return; }
        helper(node.right, k);
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
