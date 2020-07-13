public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {

    private int inIndex = 0;
    private int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, (long) Integer.MIN_VALUE - 1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, long stop) {
        if (preIndex >= preorder.length) return null;
        if (inorder[inIndex] == stop) {
            inIndex++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[preIndex++]);
        node.left = helper(preorder, inorder, node.val);
        node.right = helper(preorder, inorder, stop);
        return node;
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        return helper1(preorder, inorder, 0, 0, preorder.length);
    }

    private TreeNode helper1(int[] preorder, int[] inorder, int preStart, int inStart, int length) {
        if (length == 0) return null;
        int rootVal = preorder[preStart++];
        TreeNode root = new TreeNode(rootVal, null, null);
        if (length == 1) return root;
        int nLength, rIndex = inStart;
        for (nLength = 0; nLength < length; ++nLength)
            if (rootVal == inorder[rIndex++]) break;
        root.left = helper1(preorder, inorder, preStart, inStart, nLength);
        root.right = helper1(preorder, inorder, preStart + nLength, rIndex, length - nLength - 1);
        return root;
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
