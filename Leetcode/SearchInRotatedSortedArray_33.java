public class SearchInRotatedSortedArray_33 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lower = 0, upper = nums.length - 1;
        while (lower <= upper) {
            int mid = (lower + upper) / 2;
            if (nums[mid] == target) return mid;
            if (target < nums[mid]) {
                if (target <= nums[upper] && nums[upper] < nums[mid]) lower = mid + 1;
                else upper = mid - 1;
            } else {
                if (nums[mid] < nums[lower] && nums[lower] <= target) upper = mid - 1;
                else lower = mid + 1;
            }
        }
        return -1;
    }

}
