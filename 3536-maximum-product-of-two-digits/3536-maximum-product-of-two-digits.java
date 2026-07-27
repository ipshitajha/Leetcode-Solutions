class Solution {
    public int maxProduct(int n) {
        int l=0;
        int n1=n;
        while(n1!=0)
        {
            n1=n1/10;
            l++;
        }
        int arr[]=new int[l];
        int i=0;
        int r;
        while(n!=0)
        {
            r=n%10;
            n=n/10;
            arr[i]=r;
            i++;
        }
        Arrays.sort(arr);
        int product=arr[l-1]*arr[l-2];
        return product;
        
    }
}