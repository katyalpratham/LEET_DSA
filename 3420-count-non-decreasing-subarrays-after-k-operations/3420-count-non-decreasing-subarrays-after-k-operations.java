import java.util.*;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) pre[i + 1] = pre[i] + nums[i];

        Deque<Integer> dq = new ArrayDeque<>(); // indices of prefix-max records
        long total = 0;   // sum of target values over window [l, r]
        long count = 0;
        int r = n - 1;

        for (int l = n - 1; l >= 0; l--) {
            // nums[l] absorbs every record with value <= nums[l]
            while (!dq.isEmpty() && nums[dq.peekFirst()] <= nums[l]) {
                int j = dq.pollFirst();
                int next = dq.isEmpty() ? r + 1 : dq.peekFirst();
                total -= (long) nums[j] * (next - j);
            }
            int next = dq.isEmpty() ? r + 1 : dq.peekFirst();
            total += (long) nums[l] * (next - l);
            dq.addFirst(l);

            // shrink from the right while cost > k
            while (total - (pre[r + 1] - pre[l]) > k) {
                int last = dq.peekLast();
                total -= nums[last];      // element r loses its target value
                if (last == r) dq.pollLast(); // its segment is now empty
                r--;
            }

            count += r - l + 1;
        }

        return count;
    }
}