import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SerializeAndDeserializeBinaryTree_297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() != 0) {
            TreeNode cur = queue.poll();
            if (cur == null) sb.append("null,");
            else {
                sb.append(cur.val); sb.append(',');
                queue.offer(cur.left); queue.offer(cur.right);
            }
        }
        if (sb.charAt(sb.length() - 1) == ',') sb.deleteCharAt(sb.length() - 1);
        sb.append(']');
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        StringTokenizer tokens = new StringTokenizer(data.substring(1, data.length() - 1), ",");
        int length = tokens.countTokens();
        if (length == 0) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = null;
        String token;
        if (tokens.hasMoreTokens() && !"null".equals(token = tokens.nextToken()))
            queue.offer(root = new TreeNode(Integer.parseInt(token)));
        while (tokens.hasMoreTokens()) {
            TreeNode parent = queue.poll();
            if (!"null".equals(token = tokens.nextToken()))
                queue.offer(parent.left = new TreeNode(Integer.parseInt(token)));
            if (tokens.hasMoreTokens() && !"null".equals(token = tokens.nextToken()))
                queue.offer(parent.right = new TreeNode(Integer.parseInt(token)));
        }
        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
