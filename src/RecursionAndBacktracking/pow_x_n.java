package RecursionAndBacktracking;

class Solution {
    public double myPow(double x, int n) {
        long power = n;
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }
        return helper(x, power);
    }

    private double helper(double x, long n) {
        if (n == 0) return 1.0;

        double half = helper(x, n / 2);

        // If n is even, x^n = (x^(n/2))^2
        // If n is odd, x^n = (x^(n/2))^2 * x
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
