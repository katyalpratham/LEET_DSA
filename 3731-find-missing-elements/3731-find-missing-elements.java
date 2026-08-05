import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        // Find the minimum and maximum values
        int min = nums[0];
        int max = nums[0];
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
            set.add(num); // Add to set for O(1) lookup
        }

        // Collect all integers missing between min and max
        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }
}
