class Solution {
    public boolean isPalindrome(int x) {
        
        if(x<0)
        {
            return false;
        }
        else{
             int temp=x;
             int rev=0;
             int d;
            while(temp!=0)
            {
                d=temp%10;
                rev=(rev*10)+d;
                temp=temp/10;  
            }
            if(rev==x)
            return true;
            else
            return false;
            }

    }
    
        
}