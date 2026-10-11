class Solution {
    public int sumOfSquares(int[] nums) {
        int sumOfSquares = 0;
        int n = nums.length;
        int square = 1;
        for (int i = 1; i <= n; i++) {
            if (n % i== 0) {

                sumOfSquares = sumOfSquares + (nums[i-1] * nums[i-1]);
            }
        }
        return sumOfSquares;
    }
}