class Solution {
    public int maxDistance(int[] position, int m) {
        final int N = position.length;
        Arrays.sort(position);
        int low = 1, high = (position[N - 1] - position[0]) / (m - 1);
        int res = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isValid(position, mid, m)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    private boolean isValid(int[] position, int size, int balls) {
        int curr = -size;
        for (int next : position) {
            if (next - curr < size) {
                continue;
            }
            curr = next;
            balls--;
            if (balls == 0) {
                return true;
            }
        }
        return false;
    }
}