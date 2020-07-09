public class ValidateBinarySearchTree_98 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root) != null;
    }

    private int[] helper(TreeNode root) {
        if (root == null) return null;
        int[] left = helper(root.left);
        if (root.left != null && (left == null || root.val <= left[1])) return null;
        int[] right = helper(root.right);
        if (root.right != null && (right == null || right[0] <= root.val)) return null;
        if (left == null && right == null) return new int[]{root.val, root.val};
        if (left == null) { right[0] = root.val; return right; }
        if (right == null) { left[1] = root.val; return left; }
        left[1] = right[1]; return left;
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
