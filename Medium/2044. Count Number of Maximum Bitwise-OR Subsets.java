import java.util.HashMap;
import java.util.Map;

/**
 * Backtracking solution to count the number of subsets with maximum bitwise OR.
 */
class Backtracking {
    private int count = 0;

    /**
     * Calculates the number of subsets whose bitwise OR is maximized.
     *
     * @param nums input array of integers
     * @return count of subsets with maximum OR
     */
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        // Compute the maximum possible OR value for the array
        for (int num : nums) {
            maxOr |= num;
        }
        // Start backtracking from index 0, with current OR as 0
        backtrack(nums, 0, 0, maxOr);
        return count;
    }

    /**
     * Recursively explores all subset combinations.
     * If the current OR equals the maximum, all remaining elements can be
     * included/excluded freely,
     * so we add 2^(n-idx) to the count.
     */
    private void backtrack(int[] nums, int idx, int currOr, int maxOr) {
        if (currOr == maxOr) {
            count += 1 << (nums.length - idx);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            backtrack(nums, i + 1, currOr | nums[i], maxOr);
        }
    }
}

/**
 * Enumeration (dynamic programming) solution to count the number of subsets
 * with maximum bitwise OR.
 */
class Enumeration {
    /**
     * Calculates the number of subsets whose bitwise OR is maximized.
     *
     * @param nums input array of integers
     * @return count of subsets with maximum OR
     */
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        // prev maps OR value to the number of ways to achieve it
        Map<Integer, Integer> prev = new HashMap<>();
        prev.put(0, 1); // Start with the empty subset

        for (int num : nums) {
            maxOr |= num;
            Map<Integer, Integer> curr = new HashMap<>();
            // For each previous OR value, add the current number to the subset
            for (Map.Entry<Integer, Integer> entry : prev.entrySet()) {
                int newOr = entry.getKey() | num;
                curr.put(newOr, curr.getOrDefault(newOr, 0) + entry.getValue());
            }
            // Merge current results back into prev for the next iteration
            for (Map.Entry<Integer, Integer> entry : curr.entrySet()) {
                prev.put(entry.getKey(), prev.getOrDefault(entry.getKey(), 0) + entry.getValue());
            }
        }
        // Return the number of ways to achieve the maximum OR
        return prev.getOrDefault(maxOr, 0);
    }
}