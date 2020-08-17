public class ReverseBits_190 {

    public int reverseBits(int n) {
        int left = 0x80000000, right = 0x1;
        int result = 0;
        for (int i = 0; i < 16; ++i) {
            if ((n & left) != 0) result |= right;
            if ((n & right) != 0) result |= left;
            left >>>= 1; right <<= 1;
        }
        return result;
    }

}
