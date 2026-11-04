import java.util.*;

class Solution {
    int m;
    long[] cnt, sm;

    void upd(int i, int c, long v) {
        for (; i <= m; i += i & -i) {
            cnt[i] += c;
            sm[i] += v;
        }
    }

    // returns {count, sum} of elements with compressed index <= i
    long[] pref(int i) {
        long c = 0, s = 0;
        for (; i > 0; i -= i & -i) {
            c += cnt[i];
            s += sm[i];
        }
        return new long[]{c, s};
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        // coordinate compression
        int[] vals = Arrays.stream(nums).distinct().sorted().toArray();
        m = vals.length;
        int[] idx = new int[n];
        for (int i = 0; i < n; i++) {
            idx[i] = Arrays.binarySearch(vals, nums[i]) + 1;
        }

        cnt = new long[m + 1];
        sm = new long[m + 1];

        int top = 1;
        while (top * 2 <= m) top *= 2;

        // cost of each window of size x
        long[] costs = new long[n - x + 1];
        long total = 0;
        for (int i = 0; i < n; i++) {
            upd(idx[i], 1, nums[i]);
            total += nums[i];
            if (i >= x) {
                upd(idx[i - x], -1, -nums[i - x]);
                total -= nums[i - x];
            }
            if (i >= x - 1) {
                // find compressed index of the ((x+1)/2)-th smallest element
                int kk = (x + 1) / 2;
                int pos = 0;
                for (int pw = top; pw > 0; pw >>= 1) {
                    int nxt = pos + pw;
                    if (nxt <= m && cnt[nxt] < kk) {
                        pos = nxt;
                        kk -= cnt[nxt];
                    }
                }
                int mi = pos + 1;
                long med = vals[mi - 1];
                long[] p = pref(mi);
                long c = p[0], s = p[1];
                costs[i - x + 1] = med * c - s + (total - s) - med * (x - c);
            }
        }

        // DP: pick k non-overlapping windows
        final long INF = Long.MAX_VALUE / 4;
        long[] prev = new long[n + 1]; // j = 0, all zeros
        for (int j = 1; j <= k; j++) {
            long[] cur = new long[n + 1];
            Arrays.fill(cur, INF);
            for (int i = x; i <= n; i++) {
                long v = prev[i - x] >= INF ? INF : prev[i - x] + costs[i - x];
                cur[i] = Math.min(cur[i - 1], v);
            }
            prev = cur;
        }
        return prev[n];
    }
}