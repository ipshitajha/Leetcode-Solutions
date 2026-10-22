
class Solution {
    private int rotationCost(int k, int n) {
        if (k == 0) return 0;
        return Math.min(k, n - k + 2);
    }

    public int minOperations(int[] nums) {
        int n = nums.length;
        int zeroIndex = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroIndex = i;
                break;
            }
        }

        // Case 1: nums is a rotation of [0, 1, ..., n-1]
        boolean normal = true;
        for (int i = 0; i < n; i++) {
            if (nums[(i + zeroIndex) % n] != i) {
                normal = false;
                break;
            }
        }

        int ans = normal ? rotationCost(zeroIndex, n)
                         : Integer.MAX_VALUE;

        // Case 2: nums has reversed circular order
        int k = nums[0];
        boolean reversed = true;

        for (int i = 0; i < n; i++) {
            if (nums[i] != (k - i + n) % n) {
                reversed = false;
                break;
            }
        }

        if (reversed) {
            int a = (n - 1 - k + n) % n;
            int b = (k + 1) % n;

            ans = Math.min(ans, rotationCost(a, n) + 1);
            ans = Math.min(ans, rotationCost(b, n) + 1);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
