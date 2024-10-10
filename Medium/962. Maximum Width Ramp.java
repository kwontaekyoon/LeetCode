import java.util.ArrayDeque;
import java.util.TreeMap;

// Monotonic Stack -> O(n)
class Solution {
    public int maxWidthRamp(int[] nums) {
        final int n = nums.length;
        final var stack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[stack.peekLast()] > nums[i]) {
                stack.offerLast(i);
            }
        }
        System.out.println(stack);
        int res = 0;
        for (int i = n - 1; i > 0; i--) {
            while (!stack.isEmpty() && nums[stack.peekLast()] <= nums[i]) {
                res = Math.max(res, i - stack.pollLast());
            }
        }
        return res;
    }
}

// TLE
class Solution1 {
    public int maxWidthRamp(int[] nums) {
        final var map = new TreeMap<Integer, Integer>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (var key : map.keySet()) {
                if (key > nums[i]) {
                    break;
                }
                max = Math.max(max, i - map.get(key));
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        return max;
    }
}