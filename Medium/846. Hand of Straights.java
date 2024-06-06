class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        final int N = hand.length;
        Arrays.sort(hand);
        for (int i = 0; i < N; i++) {
            if (hand[i] < 0) {
                continue;
            }
            if (!isValid(hand, groupSize, i, N)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValid(int[] nums, int groupSize, int i, int N) {
        int currSize = 0, currTarget = nums[i];
        for (int j = i; j < N && currSize < groupSize; j++) {
            if (nums[j] > currTarget) {
                break;
            }
            if (nums[j] < currTarget) {
                continue;
            }
            currTarget++;
            currSize++;
            nums[j] = -1;
        }
        return currSize == groupSize;
    }
}

class Solution1 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        final int N = hand.length;
        final var MAP = new HashMap<Integer, Integer>();
        Arrays.sort(hand);
        for (int num : hand) {
            MAP.put(num, MAP.getOrDefault(num, 0) + 1);
        }
        for (int num : hand) {
            int size = MAP.get(num);
            if (size < 1) {
                continue;
            }
            for (int i = num; i < num + groupSize; i++) {
                if (MAP.getOrDefault(i, 0) < size) {
                    return false;
                }
                MAP.put(i, MAP.get(i) - size);
            }
        }
        return true;
    }
}