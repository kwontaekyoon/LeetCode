import java.util.Arrays;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
        while (left < right) {
            int mid = (left + right) / 2;
            if (issmallpairs(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean issmallpairs(int[] nums, int k, int mid) {
        int count = 0, left = 0;
        for (int right = 1; right < nums.length; right++) {
            while (nums[right] - nums[left] > mid) {
                left++;
            }
            count += right - left;
        }
        return count >= k;
    }
}

class Solution1 {
    public int smallestDistancePair(int[] nums, int k) {
        final int n = nums.length;
        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            if (n - i < k) {
                k -= n - i;
                continue;
            }
            final var dists = new int[n - i];
            for (int j = i, idx = 0; j < n; j++, idx++) {
                dists[idx] = nums[j] - nums[j - i];
            }
            Arrays.sort(dists);
            return dists[k - 1];
        }
        return 0;
    }
}