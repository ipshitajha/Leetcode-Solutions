class Solution {
    public int countCommas(long n) {
        long ans = 0;
        long x = 1000;

        while (x <= n) {
            ans += n - x + 1;
            x *= 1000;
        }

        return (int) ans;
    }
}