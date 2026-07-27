class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int l=nums.length;
        int product=(nums[l-1]-1)*(nums[l-2]-1);
        return product;
    }
}