public class ReverseInteger_7 {

    public int reverse(int x) {
        boolean isNegative = x < 0;
        long result = 0;
        while (x != 0) {
            result *= 10;
            result += x % 10;
            x /= 10;
        }
        if (isNegative) {
            return (result >= Integer.MIN_VALUE) ? (int) result : 0;
        } else {
            return (result <= Integer.MAX_VALUE) ? (int) result : 0;
        }
    }

}
