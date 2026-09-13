import java.util.*;

class Solution {
    static class Interval {
        int l, r, w, index;

        Interval(int l, int r, int w, int index) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.index = index;
        }
    }

    static class Result {
        long score;
        List<Integer> indices;

        Result(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        Interval[] a = new Interval[n];

        for (int i = 0; i < n; i++) {
            a[i] = new Interval(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        Arrays.sort(a, (x, y) -> {
            if (x.l != y.l)
                return Integer.compare(x.l, y.l);
            if (x.r != y.r)
                return Integer.compare(x.r, y.r);
            return Integer.compare(x.index, y.index);
        });

        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n;

            while (left < right) {
                int mid = (left + right) / 2;

                if (a[mid].l > a[i].r)
                    right = mid;
                else
                    left = mid + 1;
            }

            next[i] = left;
        }

        Result[][] dp = new Result[n + 1][5];

        for (int k = 0; k <= 4; k++) {
            dp[n][k] = new Result(0, new ArrayList<>());
        }

        for (int i = n - 1; i >= 0; i--) {
            dp[i][0] = new Result(0, new ArrayList<>());

            for (int k = 1; k <= 4; k++) {

                // Don't choose this interval
                Result skip = dp[i + 1][k];

                // Choose this interval
                Result nextResult = dp[next[i]][k - 1];

                List<Integer> list = new ArrayList<>(nextResult.indices);
                list.add(a[i].index);
                Collections.sort(list);

                Result take = new Result(
                    a[i].w + nextResult.score,
                    list
                );

                if (take.score > skip.score ||
                    (take.score == skip.score &&
                     lexicographicallySmaller(take.indices, skip.indices))) {
                    dp[i][k] = take;
                } else {
                    dp[i][k] = skip;
                }
            }
        }

        List<Integer> answer = dp[0][4].indices;

        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    private boolean lexicographicallySmaller(
        List<Integer> a,
        List<Integer> b) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}