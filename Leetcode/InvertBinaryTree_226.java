public class InvertBinaryTree_226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    public TreeNode invertTree1(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode node) {
        if (node == null) return;
        helper(node.left);
        helper(node.right);
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
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
