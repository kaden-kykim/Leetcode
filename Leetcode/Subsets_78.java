import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) return result;
        helper(0, new ArrayList<>(), nums, result);
        return result;
    }

    private void helper(int curIndex, List<Integer> curList, int[] nums, List<List<Integer>> result) {
        result.add(curList);
        for (int i = curIndex; i < nums.length; ++i) {
            int index = i;
            helper(index + 1, new ArrayList<Integer>(curList) {{ add(nums[index]); }}, nums, result);
        }
    }

}
