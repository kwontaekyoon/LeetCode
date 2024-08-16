import java.util.List;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        final int n = arrays.size();
        int smallestVal = Integer.MAX_VALUE, smallestIdx = -1;
        int secondSmallestVal = Integer.MAX_VALUE;
        int biggestVal = Integer.MIN_VALUE, biggestIdx = -1;
        int secondBiggestVal = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            final List<Integer> curr = arrays.get(i);
            final int min = curr.get(0);
            final int max = curr.get(curr.size() - 1);
            if (min < smallestVal) {
                secondSmallestVal = smallestVal;
                smallestVal = min;
                smallestIdx = i;
            } else if (min < secondSmallestVal) {
                secondSmallestVal = min;
            }
            if (max > biggestVal) {
                secondBiggestVal = biggestVal;
                biggestVal = max;
                biggestIdx = i;
            } else if (max > secondBiggestVal) {
                secondBiggestVal = max;
            }
        }
        if (biggestIdx != smallestIdx) {
            return biggestVal - smallestVal;
        }
        return Math.max(secondBiggestVal - smallestVal, biggestVal - secondSmallestVal);
    }
}

// TLE N^2
class Solution1 {
    public int maxDistance(List<List<Integer>> arrays) {
        final int n = arrays.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            final var x = arrays.get(i).size();
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                final var y = arrays.get(j).size();
                res = Math.max(
                        res, Math.max(
                                Math.abs(arrays.get(i).get(0) - arrays.get(j).get(y - 1)),
                                Math.abs(arrays.get(i).get(x - 1) - arrays.get(j).get(0))));
            }
        }
        return res;
    }
}
