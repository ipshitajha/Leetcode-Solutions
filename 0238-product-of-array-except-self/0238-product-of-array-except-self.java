class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];

        // 1. Store LEFT products
        int left = 1;

        for (int i = 0; i < n; i++) {
            answer[i] = left;
            left = left * nums[i];
        }

        // 2. Multiply by RIGHT products
        int right = 1;

        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * right;
            right = right * nums[i];
        }

        return answer;
    }
}