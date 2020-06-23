public class DivideTwoIntegers_29 {

    public int divide(int dividend, int divisor) {
        boolean isNeg = dividend < 0 ^ divisor < 0;
        long lDividend = Math.abs((long) dividend), lDivisor = Math.abs((long) divisor), result = 0;
        int count = 0;
        while (lDividend >= lDivisor) { lDivisor <<= 1; ++count; }
        for (int i = 0; i <= count; ++i) {
            if (lDividend == 0) { result <<= count - 1; break; }
            result <<= 1;
            if (lDividend >= lDivisor) { ++result; lDividend -= lDivisor; }
            lDivisor >>= 1;
        }
        return (int) ((isNeg) ? -result : ((result <= Integer.MAX_VALUE) ? result : Integer.MAX_VALUE));
    }

}
