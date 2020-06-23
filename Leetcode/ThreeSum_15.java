import java.util.*;

public class ThreeSum_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int len = nums.length;
        if (len == 0) return new ArrayList<>(result);
        Map<Integer, Integer> numbers = new HashMap<>();
        for (Integer i : nums) {
            numbers.put(i, (numbers.containsKey(i)) ? numbers.get(i) + 1 : 1);
        }

        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int op1 = nums[i], op2 = nums[j];
                int res = -(op1 + op2);
                if (!(op1 == 0 && op2 == 0 && numbers.get(0) >= 3) && (res == op1 || res == op2)) continue;
                if (numbers.containsKey(res)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(op1);
                    list.add(op2);
                    list.add(res);
                    list.sort(Integer::compare);
                    result.add(list);
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        System.out.println("[[-1, 0, 1], [-1, -1, 2]]: " + new ThreeSum_15().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println("[[0, 0, 0]]: " + new ThreeSum_15().threeSum(new int[]{0, 0, 0, 0}));
        System.out.println("[[0, 0, 0]]: " + new ThreeSum_15().threeSum(new int[]{0, 0, 0}));
        System.out.println("[]: " + new ThreeSum_15().threeSum(new int[]{0, 0}));
    }

}
