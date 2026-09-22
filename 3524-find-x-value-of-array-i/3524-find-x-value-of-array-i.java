class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {

            int a = num % k;

            long[] next = new long[k];

            // Subarray containing only this element
            next[a]++;

            // Extend previous subarrays
            for (int r = 0; r < k; r++) {

                if (dp[r] == 0)
                    continue;

                int newRemainder = (int)((long) r * a % k);

                next[newRemainder] += dp[r];
            }

            // Add all subarrays ending at current position
            for (int r = 0; r < k; r++) {
                result[r] += next[r];
            }

            dp = next;
        }

        return result;
    }
}