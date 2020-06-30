import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {

    private List<List<Integer>> result = new ArrayList<>();
    private int[] nums;
    private int length;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return result;
        this.nums = nums;
        this.length = nums.length;
        for (int i = 0; i < length; ++i) {
            List<Integer> curList = new ArrayList<>();
            curList.add(nums[i]);
            boolean[] inserted = new boolean[length];
            inserted[i] = true;
            helper(length - 1, i, curList, inserted);
        }

        return result;
    }

    private void helper(int remaining, int curPos, List<Integer> curList, boolean[] inserted) {
        if (remaining == 0) { result.add(new ArrayList<>(curList)); return; }
        for (int i = 0; i < remaining; ++i) {
            do {
                curPos = ++curPos % length;
            } while (inserted[curPos]);
            curList.add(nums[curPos]);
            inserted[curPos] = true;
            helper(remaining - 1, curPos, curList, inserted);
            curList.remove(curList.size() - 1);
            inserted[curPos] = false;
        }
    }

}
