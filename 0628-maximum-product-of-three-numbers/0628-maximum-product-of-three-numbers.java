class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int l=nums.length;
        int m=nums[0]*nums[1]*nums[l-1];
        int n=nums[l-1]*nums[l-2]*nums[l-3];

      if(m>n)
      {
        return m;
      }
      else 
      {
        return n;
      }
        
    }
}