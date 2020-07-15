import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode_116 {

    public Node connect(Node root) {
        helper(root);
        return root;
    }

    private void helper(Node node) {
        if (node == null) return;
        if (node.left != null) node.left.next = node.right;
        Node lastChild = (node.right != null) ? node.right : node.left;
        if (lastChild != null) {
            lastChild.next = (node.next != null) ? (node.next.left != null) ? node.next.left : node.next.right : null;
        }
        helper(node.left);
        helper(node.right);
    }

    public Node connect1(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prevNode = queue.poll();
            if (prevNode.left != null) queue.add(prevNode.left);
            if (prevNode.right != null) queue.add(prevNode.right);
            for (int i = 1; i < size; ++i) {
                prevNode.next = queue.poll();
                prevNode = prevNode.next;
                assert prevNode != null;
                if (prevNode.left != null) queue.add(prevNode.left);
                if (prevNode.right != null) queue.add(prevNode.right);
            }
        }
        return root;
    }

    public Node connect2(Node root) {
        Queue<Node> parents, children = new LinkedList<>();
        if (root != null) children.add(root);
        while (!children.isEmpty()) {
            parents = children;
            children = new LinkedList<>();
            while (!parents.isEmpty()) {
                Node node = parents.poll();
                node.next = parents.peek();
                if (node.left != null) children.add(node.left);
                if (node.right != null) children.add(node.right);
            }
        }
        return root;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
