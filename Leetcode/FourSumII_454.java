import java.util.HashMap;
import java.util.Map;

public class FourSumII_454 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>(A.length * A.length);
        for (int i : A) for (int j : B) map.put(i + j, map.getOrDefault(i + j, 0) + 1);
        for (int i : C) for (int j : D) count += map.getOrDefault(-(i + j), 0);
        return count;
    }

}
