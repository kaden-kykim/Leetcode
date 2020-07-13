public class ConvertSortedArrayToBinarySearchTree_108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        return helper(nums, 0, nums.length);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        int length = end - start;
        if (length == 0) return null;
        if (length == 1) return new TreeNode(nums[start]);
        int rootIndex = start + (length >> 1);
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = helper(nums, start, rootIndex);
        root.right = helper(nums, rootIndex + 1, end);
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
