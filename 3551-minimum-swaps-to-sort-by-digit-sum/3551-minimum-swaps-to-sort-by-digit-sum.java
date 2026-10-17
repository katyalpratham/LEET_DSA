import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        // indices sorted by (digit sum, value)
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;

        Arrays.sort(idx, (a, b) -> {
            int sa = digitSum(nums[a]), sb = digitSum(nums[b]);
            return sa != sb ? sa - sb : nums[a] - nums[b];
        });

        // count swaps = sum of (cycle length - 1)
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            int j = i, len = 0;
            while (!visited[j]) {
                visited[j] = true;
                j = idx[j];
                len++;
            }
            swaps += len - 1;
        }

        return swaps;
    }

    private int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}