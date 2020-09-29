public class PowerOfThree_326 {

    public boolean isPowerOfThree(int n) {
        int mul = 1;
        for (int i = 0; i < 20; ++i) { if (mul == n) return true; mul *= 3; }
        return false;
    }

    public boolean isPowerOfThree1(int n) {
        if (n <= 0) return false;
        while (n % 3 == 0) n /= 3;
        return n == 1;
    }

}
