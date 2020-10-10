import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShuffleAnArray_384 {

    private final int[] nums, shuffled;
    private final int length;
    private final List<Integer> list;
    private final Random random;

    public ShuffleAnArray_384(int[] nums) {
        this.nums = nums;
        length = nums.length;
        shuffled = new int[length];
        list = new ArrayList<>();
        for (int num : nums) list.add(num);
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List<Integer> list = new ArrayList<>(this.list);
        for (int i = length - 1; i >= 0; --i) shuffled[i] = list.remove(random.nextInt(i + 1));
        return shuffled;
    }

}
