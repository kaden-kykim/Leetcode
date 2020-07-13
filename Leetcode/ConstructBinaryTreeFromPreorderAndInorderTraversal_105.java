public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        return helper(preorder, inorder, 0, 0, preorder.length);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int length) {
        if (length == 0) return null;
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal, null, null);
        if (length == 1) return root;
        int rIndex = inStart;
        for (int i = inStart; i < inStart + length; ++i) {
            if (rootVal == inorder[i]) { rIndex = i; break; }
        }
        int nLength = rIndex - inStart;
        root.left = helper(preorder, inorder, preStart + 1, inStart, nLength);
        root.right = helper(preorder, inorder, preStart + nLength + 1, rIndex + 1, length - nLength - 1);
        return root;
    }

//    public static void main(String[] args) {
//        TreeNode result = new ConstructBinaryTreeFromPreorderAndInorderTraversal_105().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
//        System.out.println(result);
//        TreeNode result1 = new ConstructBinaryTreeFromPreorderAndInorderTraversal_105().buildTree(new int[]{1, 2, 3}, new int[]{2, 3, 1});
//        System.out.println(result1);
//    }

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
