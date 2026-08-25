import java.util.*;

class Solution {
    public int missingMultiple(int[] nums, int k) {
        
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (num % k == 0) {
                set.add(num);
            }
        }

        int j = 1;

        while (true) {
            int multiple = k * j;

            if (!set.contains(multiple)) {
                return multiple;
            }

            j++;
        }
    }
}