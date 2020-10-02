public class IncreasingTripletSubsequence_334 {

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int cur = nums[i], next = nums[i + 1];
            if (cur < next) {
                if (min2 < cur || min2 < next || min1 < cur) return true;
                min1 = cur; min2 = next;
            }
        }
        return false;
    }

    public boolean increasingTriplet1(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int count = 0, smallest = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; --i)
            if (nums[i] < smallest) { smallest = nums[i]; if (++count >= 3) break; }
        if (count >= 3) return true;

        count = 0;
        int larger = Integer.MIN_VALUE, largest = larger;
        for (int num : nums) {
            if (larger < num && num < largest) { larger = largest; largest = num; }
            else if (largest < num) { larger = largest; largest = num; if (++count >= 3) break; }
        }
        return count >= 3;
    }

}
