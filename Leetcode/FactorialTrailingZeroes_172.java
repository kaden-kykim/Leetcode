public class FactorialTrailingZeroes_172 {

    public int trailingZeroes(int n) {
        int result = 0;
        long n5 = 5;
        while (n5 <= n) { result += n / n5; n5 *= 5; }
        return result;
    }

    public int trailingZeroes1(int n) {
        int count = 0;
        while (n > 0) { count += n / 5; n /= 5; }
        return count;
    }

}
