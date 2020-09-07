import java.util.Stack;

public class LowestCommonAncestorOfABinaryTree_236 {

    private TreeNode[] ancestors1, ancestors2;
    private boolean isFoundAncestors;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p.val == root.val || q.val == root.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left != null && right != null ? root : left != null ? left : right;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        getAncestors(new Stack<>(), root, p, q);
        TreeNode[] lower, higher;
        if (ancestors1.length < ancestors2.length) { lower = ancestors2; higher = ancestors1; }
        else { lower = ancestors1; higher = ancestors2; }
        int left = 0, right = higher.length - 1;
        if (lower[right].val == higher[right].val) return higher[right];
        int length = right - left;
        while (length > 1) {
            int halfLength = length / 2, newL = left + halfLength, newR = right - halfLength;
            if (lower[newL] == higher[newL]) {
                left = newL; length = right - left;
            } else if (lower[newR] != higher[newR]) {
                right = newR; length = right - left;
            }
        }
        return higher[left];
    }

    private void getAncestors(Stack<TreeNode> ancestors, TreeNode node, TreeNode p, TreeNode q) {
        if (isFoundAncestors || node == null) return;
        ancestors.push(node);
        if (node.val == p.val || node.val == q.val) {
            if (ancestors1 == null)
                ancestors1 = ancestors.toArray(new TreeNode[0]);
            else if (ancestors2 == null) {
                ancestors2 = ancestors.toArray(new TreeNode[0]);
                isFoundAncestors = true;
                return;
            }
        }
        getAncestors(ancestors, node.left, p, q);
        getAncestors(ancestors, node.right, p, q);
        ancestors.pop();
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
