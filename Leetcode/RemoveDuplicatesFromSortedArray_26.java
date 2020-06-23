public class RemoveDuplicatesFromSortedArray_26 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int temp = nums[0], curIndex = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (temp != nums[i]) {
                temp = nums[i];
                nums[curIndex++] = nums[i];
            }
        }
        return curIndex;
    }

}
