class Solution {
    public long sumAndMultiply(int n) {

        int temp = n;
        int l = 0;

        while (temp != 0) {
            temp /= 10;
            l++;
        }

        int[] arr = new int[l];

        int index = l - 1;

        while (n != 0) {
            arr[index] = n % 10;
            n /= 10;
            index--;
        }

        int sum = 0;
        String s = "";

        for (int i = 0; i < l; i++) {
            if (arr[i] != 0) {
                s += arr[i];
                sum += arr[i];
            }
        }

        int x = 0;
        if (!s.equals("")) {
            x = Integer.parseInt(s);
        }

        return (long)x * sum;
    }
}