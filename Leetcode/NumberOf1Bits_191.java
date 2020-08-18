public class NumberOf1Bits_191 {

    public int hammingWeight(int n) {
        int checkBit = 0x1, count = 0;
        for (int i = 0; i < 32; ++i) {
            if ((n & checkBit) != 0) ++count;
            checkBit <<= 1;
        }
        return count;
    }

}
