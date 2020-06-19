import java.util.HashMap;

public class TwoSum_1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int curNum = nums[i];
            int opNum = target - curNum;
            if (numsMap.containsKey(opNum)) {
                return new int[]{Math.min(i, numsMap.get(opNum)), Math.max(i, numsMap.get(opNum))};
            } else {
                numsMap.put(curNum, i);
            }
        }
        return null;
    }

}