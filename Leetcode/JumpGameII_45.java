public class JumpGameII_45 {

    public int jump(int[] nums) {
        int length = nums.length;
        if (length == 1) return 0;
        int count = 0, curIndex = 0, startIndex = 0;
        while (true) {
            ++count;
            int endIndex = curIndex + 1;
            for (int i = startIndex; i < endIndex; ++i) {
                curIndex = Math.max(curIndex, nums[i] + i);
                if (length - 1 <= curIndex) return count;
            }
            startIndex = endIndex;
        }
    }

    public int jump1(int[] nums) {
        int length = nums.length;
        if (length == 1) return 0;
        int[] minCount = new int[length];
        for (int i = 0; i < length - 1; ++i) {
            int num = nums[i];
            for (int j = 1; j <= num; ++j) {
                int index = i + j;
                if (index < length) {
                    minCount[index] = minCount[index] == 0 ? minCount[i] + 1 : Math.min(minCount[index], minCount[i] + 1);
                }
            }
        }
        return minCount[length - 1];
    }

}
