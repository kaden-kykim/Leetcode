import java.util.*;

public class ThreeSum_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;
        int length = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < length && nums[i] <= 0; ++i) {
            if (i == 0 || nums[i - 1] != nums[i]) twoSum(nums, i, result);
        }
        return result;
    }

    public void twoSum(int[] nums, int index, List<List<Integer>> result) {
        int target = -nums[index];
        int left = index + 1, right = nums.length - 1;
        while (left < right) {
            int val = nums[left] + nums[right];
            if (val < target) ++left;
            else if (target < val) --right;
            else {
                result.add(Arrays.asList(-target, nums[left++], nums[right--]));
                while (left < right && nums[left] == nums[left - 1]) ++left;
            }
        }
    }

    public List<List<Integer>> threeSum1(int[] nums) {
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
                    List<Integer> list = Arrays.asList(op1, op2, res);
                    list.sort(Integer::compare);
                    result.add(list);
                }
            }
        }
        return new ArrayList<>(result);
    }

}
