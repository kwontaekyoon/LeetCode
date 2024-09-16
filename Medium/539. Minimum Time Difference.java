import java.util.Arrays;
import java.util.List;

// O(n)
class Solution {
    public int findMinDifference(List<String> timePoints) {
        final var mins = new boolean[1440];
        for (var timeString : timePoints) {
            var timeToMins = ((timeString.charAt(0) - '0') * 10 + timeString.charAt(1) - '0') * 60
                    + ((timeString.charAt(3) - '0') * 10 + (timeString.charAt(4) - '0'));
            if (mins[timeToMins]) {
                return 0;
            }
            mins[timeToMins] = true;
        }
        int i = 0;
        while (!mins[i]) {
            i++;
        }
        int j = 1439;
        while (!mins[j]) {
            j--;
        }
        int res = 1440 - j + i;
        int prev = i++;
        while (i <= j) {
            if (mins[i]) {
                res = Math.min(res, i - prev);
                prev = i;
            }
            i++;
        }
        return res;
    }
}

// O(n ^ 2)
class Sorting {
    public int findMinDifference(List<String> timePoints) {
        final int n = timePoints.size();
        final var timeToMins = new int[n];
        for (int i = 0; i < n; i++) {
            var timeString = timePoints.get(i);
            var hr = (timeString.charAt(0) - '0') * 10 + (timeString.charAt(1) - '0');
            var min = (timeString.charAt(3) - '0') * 10 + (timeString.charAt(4) - '0');
            timeToMins[i] = hr * 60 + min;
        }
        Arrays.sort(timeToMins);
        int res = 24 * 60 - timeToMins[n - 1] + timeToMins[0];
        for (int i = 1; i < n; i++) {
            res = Math.min(res, timeToMins[i] - timeToMins[i - 1]);
        }
        return res;
    }
}