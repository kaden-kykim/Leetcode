import java.util.Stack;

public class SymmetricTree_101 {

    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    private boolean helper(TreeNode lRoot, TreeNode rRoot) {
        if (lRoot == null && rRoot == null) return true;
        else if (lRoot == null || rRoot == null) return false;
        return (lRoot.val == rRoot.val) && helper(lRoot.left, rRoot.right) && helper(lRoot.right, rRoot.left);
    }

    public boolean isSymmetricIterative(TreeNode root) {
        TreeNode lNode, rNode;
        Stack<TreeNode> lStack = new Stack<>(), rStack = new Stack<>();
        lStack.push(root);
        rStack.push(root);
        while (!(lStack.isEmpty() || rStack.isEmpty())) {
            lNode = lStack.pop();
            rNode = rStack.pop();
            if (lNode == null && rNode == null) continue;
            else if (lNode == null || rNode == null) return false;
            if (lNode.val != rNode.val) return false;
            lStack.push(lNode.right);
            lStack.push(lNode.left);
            rStack.push(rNode.left);
            rStack.push(rNode.right);
        }
        return lStack.isEmpty() && rStack.isEmpty();
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
