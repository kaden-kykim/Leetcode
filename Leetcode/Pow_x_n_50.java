public class Pow_x_n_50 {

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 1.0) return x;
        if (x == -1.0) return (n % 2 == 0) ? 1.0 : -1.0;

        x = (n < 0) ? 1.0 / x : x;
        double ans = x, rem = 1;
        long n1 = n;
        n1 = Math.abs(n1);
        while (n1 != 1) {
            if (n1 % 2 != 0) rem *= ans;
            ans *= ans;
            n1 >>= 1;
        }
        return ans * rem;
    }

}
