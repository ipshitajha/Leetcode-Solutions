
class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int insertions = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                open += 2;

                if (open % 2 == 1) {
                    insertions++;
                    open--;
                }
            } else {
                open--;

                if (open < 0) {
                    insertions++;
                    open = 1;
                }
            }
        }

        return insertions + open;
    }
}