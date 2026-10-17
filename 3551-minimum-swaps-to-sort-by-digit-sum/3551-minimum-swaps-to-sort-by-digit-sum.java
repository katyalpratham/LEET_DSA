import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        ArrayList<Integer> swap = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int store = 0;
            int num = nums[i];

            while (num > 0) {
                int digit = num % 10;
                store += digit;
                num /= 10;
            }

            swap.add(store);
        }

        int[] arr = swap.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        int[] nums1 = nums.clone();

        Integer[] order = new Integer[n];

        for (int i = 0; i < n; i++) {
            order[i] = i;
        }

        Arrays.sort(order, (a, b) -> {
            if (arr[a] != arr[b]) {
                return Integer.compare(arr[a], arr[b]);
            }
            return Integer.compare(nums1[a], nums1[b]);
        });

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || order[i] == i) {
                continue;
            }

            int cycle = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = order[j];
                cycle++;
            }

            count += cycle - 1;
        }

        return count;
    }
}