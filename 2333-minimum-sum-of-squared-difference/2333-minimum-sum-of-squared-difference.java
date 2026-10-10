class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int max = 0;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }

        // cnt[d] = number of positions with difference d
        long[] cnt = new long[max + 1];
        for (int d : diff) cnt[d]++;

        long k = (long) k1 + k2;

        // Reduce from the largest difference downward
        for (int d = max; d > 0 && k > 0; d--) {
            if (cnt[d] == 0) continue;
            if (cnt[d] <= k) {
                // lower the entire bucket by 1
                k -= cnt[d];
                cnt[d - 1] += cnt[d];
                cnt[d] = 0;
            } else {
                // only part of the bucket can be lowered
                cnt[d] -= k;
                cnt[d - 1] += k;
                k = 0;
            }
        }

        long result = 0;
        for (int d = 1; d <= max; d++) {
            result += cnt[d] * (long) d * d;
        }
        return result;
    }
}