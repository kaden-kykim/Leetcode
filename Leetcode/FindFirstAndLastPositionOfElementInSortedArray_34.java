import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray_34 {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return result;
        recSearchRange(result, 0, nums.length - 1, nums, target);
        return result;
    }

    private void recSearchRange(int[] result, int left, int right, int[] nums, int target) {
        if (left > right) return;
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            result[0] = (result[0] == -1) ? mid : Math.min(result[0], mid);
            result[1] = (result[1] == -1) ? mid : Math.max(result[1], mid);
            recSearchRange(result, left, mid - 1, nums, target);
            recSearchRange(result, mid + 1, right, nums, target);
        } else if (nums[mid] < target) {
            recSearchRange(result, mid + 1, right, nums, target);
        } else {
            recSearchRange(result, left, mid - 1, nums, target);
        }
    }

}
