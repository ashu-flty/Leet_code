class Solution {
    public int climbStairs(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n in invalid");
        }
        if (n <= 1) {
            return n;
        }

        int pre = 1; // n == 1
        int cur = 2; // n == 2
        for (int i = 3; i <= n; i++) {
            int sum = cur + pre;
            pre = cur;
            cur = sum;
        }
        return cur;
    }
}