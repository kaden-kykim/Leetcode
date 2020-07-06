public class SortColors_75 {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int first = 0, last = nums.length - 1;
        for (int i = 0; i <= last; ++i) {
            switch (nums[i]) {
                case 0:
                    nums[i] = nums[first];
                    nums[first] = 0;
                    ++first;
                    break;
                case 2:
                    nums[i] = nums[last];
                    nums[last] = 2;
                    --i; --last;
            }
        }
    }

}
