import java.util.HashSet;
import java.util.Set;

public class SingleNumber_136 {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) result ^= num;
        return result;
    }

    public int singleNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int num : nums) {
            if (!set.contains(num)) { set.add(num); sum += num; }
            else sum -= num;
        }
        return sum;
    }

}
