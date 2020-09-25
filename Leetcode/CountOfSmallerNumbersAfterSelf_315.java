import java.util.*;

public class CountOfSmallerNumbersAfterSelf_315 {

    private static class Node {
        Node left, right;
        int val, occurrence = 0, leftSum = 0;
        public Node(int val) { this.val = val; }
    }

    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        Integer[] result = new Integer[nums.length];
        Node root = new Node(nums[nums.length - 1]);
        for (int i = nums.length - 1; i >= 0; --i) result[i] = helper(root, nums[i]);
        return Arrays.asList(result);
    }

    private int helper(Node node, int val) {
        int sum = 0;
        while (node.val != val) {
            if (val < node.val) {
                ++node.leftSum;
                if (node.left == null) node.left = new Node(val);
                node = node.left;
            } else {
                sum += node.leftSum + node.occurrence;
                if (node.right == null) node.right = new Node(val);
                node = node.right;
            }
        }
        ++node.occurrence;
        return sum + node.leftSum;
    }

    private static class NumberCount {
        int number, count = 0;
        public NumberCount(int number) { this.number = number; }
    }

    public List<Integer> countSmaller1(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        Integer[] result = new Integer[nums.length];
        int[] dupArray = new int[20001];
        List<NumberCount> sortedList = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            NumberCount nc = new NumberCount(nums[i]);
            int index = Collections.binarySearch(sortedList, nc, Comparator.comparingInt(o -> o.number));
            if (index < 0) {
                index = -index - 1;
                result[i] = index;
                sortedList.add(index, nc);
            } else {
                index = index - sortedList.get(index).count;
                result[i] = index;
                int count = dupArray[nc.number + 10000];
                nc.count = count;
                sortedList.add(index + count, nc);
            }
            ++dupArray[nc.number + 10000];
        }
        return Arrays.asList(result);
    }

}
