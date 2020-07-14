import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode_116 {

    public Node connect(Node root) {
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

//    public static void main(String[] args) {
//        Node root = new Node(1,
//                new Node(2,
//                        new Node(4, null, null, null),
//                        new Node(5, null, null, null),
//                        null),
//                new Node(3,
//                        new Node(6, null, null, null),
//                        new Node(7, null, null, null),
//                        null),
//                null);
//        new PopulatingNextRightPointersInEachNode_116().connect(root);
//        System.out.println(root);
//    }

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
