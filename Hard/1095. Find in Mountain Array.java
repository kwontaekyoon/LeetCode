/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */

class Solution {
    private int getOrPut(int idx, int[] heights, MountainArray MTA) {
        if (heights[idx] == -1) {
            heights[idx] = MTA.get(idx);
        }
        return heights[idx];
    }

    private int getHighestPoint(int[] heights, MountainArray MTA, int n) {
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int now = getOrPut(m, heights, MTA);
            int pre = m > 0 ? getOrPut(m - 1, heights, MTA) : -1;
            int post = m < n - 1 ? getOrPut(m + 1, heights, MTA) : -1;
            if (now > pre && now > post) {
                return m;
            } else {
                if (now < pre && now > post) {
                    r = m - 1;
                }
                if (now > pre && now < post) {
                    l = m + 1;
                }
            }
        }
        return -1;
    }

    private int binarySearch(int[] heights, int l, int r, int target, MountainArray MTA, boolean up) {
        while (l <= r) {
            int m = (l + r) / 2;
            int now = getOrPut(m, heights, MTA);
            if (now == target) {
                return m;
            }
            if (now > target) {
                if (up) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (up) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }

    public int findInMountainArray(int target, MountainArray MTA) {
        int n = MTA.length();
        int[] heights = new int[n];
        Arrays.fill(heights, -1);
        // get highest point
        int highest = getHighestPoint(heights, MTA, n);
        // binary search
        int answer = -1;
        answer = binarySearch(heights, 0, highest, target, MTA, true);
        if (answer != -1) {
            return answer;
        }
        return binarySearch(heights, highest, n - 1, target, MTA, false);
    }
}