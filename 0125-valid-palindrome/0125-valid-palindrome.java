class Solution {
    public boolean isPalindrome(String s) {

        String s1 = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        String s2 = new StringBuilder(s1).reverse().toString();

        return s1.equals(s2);
    }
}