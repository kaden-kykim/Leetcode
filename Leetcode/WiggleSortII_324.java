import java.util.Arrays;

public class WiggleSortII_324 {

    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int length = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int halfLength = (length + 1) >> 1;
        for (int i = halfLength - 1, j = 0; i >= 0; --i, j += 2) nums[j] = sorted[i];
        for (int i = length - 1, j = 1; i >= halfLength; --i, j += 2) nums[j] = sorted[i];
    }

}
