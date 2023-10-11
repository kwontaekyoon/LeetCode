class Solution {
    private int findUpperBound(int[] starting, int target) {
        int l = 0, r = starting.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (starting[m] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    private int findLowerBound(int[] ending, int target) {
        int l = 0, r = ending.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (ending[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        // brute force
        // int[] ans = new int[people.length];
        // for (int[] flower : flowers) {
        // for (int i = 0; i < people.length; i++) {
        // if (people[i] >= flower[0] && people[i] <= flower[1]) {
        // ans[i]++;
        // }
        // }
        // }

        int[] ans = new int[people.length];
        int[] starting = new int[flowers.length];
        int[] ending = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            starting[i] = flowers[i][0];
            ending[i] = flowers[i][1];
        }
        Arrays.sort(starting);
        Arrays.sort(ending);
        for (int i = 0; i < people.length; i++) {
            int t = people[i];
            int start = findUpperBound(starting, t);
            int end = findLowerBound(ending, t);
            ans[i] = start - end;
        }
        return ans;
    }
}