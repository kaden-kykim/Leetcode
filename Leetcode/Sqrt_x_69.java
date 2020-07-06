public class Sqrt_x_69 {

    public int mySqrt(int x) {
        int pivot = (x != 1) ? x >> 1 : 1;
        long center = pivot;
        while (true) {
            if (pivot != 1) pivot >>= 1;
            long cSq = center * center;
            if (cSq <= x && x < cSq + (center << 1) + 1) return (int) center;
            center += (x < cSq) ? -pivot : pivot;
        }
    }

}
