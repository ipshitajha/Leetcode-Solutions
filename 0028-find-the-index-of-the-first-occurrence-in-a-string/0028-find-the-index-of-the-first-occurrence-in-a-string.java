
class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;

        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

                if (j == needle.length()) {
                    return i - j;
                }
            } else {
                i = i - j + 1;
                j = 0;
            }

            if (i + needle.length() - j > haystack.length()) {
                return -1;
            }
        }

        return -1;
    }
}
