class Solution {
    public boolean isPalindrome(String s) {

        String s1 = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int left=0;
        int right=s1.length()-1;
        while(left<right)
        {
            if (s1.charAt(left) != s1.charAt(right)) {
            
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}