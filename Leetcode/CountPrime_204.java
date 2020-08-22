public class CountPrime_204 {

    public int countPrimes(int n) {
        boolean[] checkPrimes = new boolean[n];
        int sqrtN = (int) Math.sqrt(n);
        int count = 0;
        for (int i = 2; i < n; ++i) {
            if (!checkPrimes[i]) {
                ++count;
                if (i <= sqrtN) {
                    int mul = i + i;
                    while (mul < n) {
                        checkPrimes[mul] = true;
                        mul += i;
                    }
                }
            }
        }
        return count;
    }

    public int countPrimes1(int n) {
        boolean[] checkPrimes = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; ++i) {
            if (!checkPrimes[i]) {
                ++count;
                int mul = i + i;
                while (mul < n) {
                    checkPrimes[mul] = true;
                    mul += i;
                }
            }
        }
        return count;
    }

}
