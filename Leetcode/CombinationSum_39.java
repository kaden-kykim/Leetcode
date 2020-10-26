import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null) return result;
        for (int i = 0; i < candidates.length; ++i) {
            int candidate = candidates[i];
            int subtract = target - candidate;
            if (subtract < 0) continue;
            if (subtract == 0) result.add(new ArrayList<Integer>(){{ add(candidate); }});
            else {
                List<List<Integer>> subResults = combinationSum(Arrays.copyOf(candidates, i + 1), subtract);
                for (List<Integer> subResult : subResults) {
                    subResult.add(candidate);
                    result.add(subResult);
                }
            }
        }
        return result;
    }

}
