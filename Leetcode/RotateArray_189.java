public class RotateArray_189 {

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }

    public void rotate1(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        if (length == 1 || k == 0) return;
        int[] rotateArray = new int[length];
        for (int i = 0; i < length; ++i) rotateArray[(i + k) % length] = nums[i];
        System.arraycopy(rotateArray, 0, nums, 0, length);
    }

}
