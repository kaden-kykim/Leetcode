import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray_448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        boolean[] check = new boolean[nums.length + 1];
        for (int num : nums) check[num] = true;
        for (int i = 1; i < check.length; ++i) { if (!check[i]) result.add(i); }
        return result;
    }

}
