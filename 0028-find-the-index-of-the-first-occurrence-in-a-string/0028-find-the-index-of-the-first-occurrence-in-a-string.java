class Solution {
    public int strStr(String haystack, String needle) {
        int i=0;
        int j=0;
        while(i<haystack.length()&& j<needle.length())
        {
            if(needle.charAt(j)==haystack.charAt(i))
            {
                i++;
                j++;
                {
                    if(j==needle.length())
                    {
                        return i-j;
                    }

                }
            }
                else 
                {
                    i=i-j+1;
                    j=0;
                }
            }
        
        return -1;

    }
}