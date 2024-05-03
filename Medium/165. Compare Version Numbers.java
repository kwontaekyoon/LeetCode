class Solution {
    public int compareVersion(String version1, String version2) {
        final var VER1 = version1.toCharArray();
        final var VER2 = version2.toCharArray();
        final int N = VER1.length;
        final int M = VER2.length;
        for (int i = 0, j = 0; i < N || j < M; i++, j++) {
            int one = 0, two = 0;
            while (i < N && VER1[i] != '.') {
                one = one * 10 + VER1[i] - '0';
                i++;
            }
            while (j < M && VER2[j] != '.') {
                two = two * 10 + VER2[j] - '0';
                j++;
            }
            if (one == two) {
                continue;
            }
            if (one > two) {
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }
}

class Solution1 {
    public int compareVersion(String version1, String version2) {
        final var VER1 = version1.split("\\.");
        final var VER2 = version2.split("\\.");
        final var N = VER1.length;
        final var M = VER2.length;
        for (int i = 0; i < N || i < M; i++) {
            int one = i < N ? Integer.parseInt(VER1[i]) : 0;
            int two = i < M ? Integer.parseInt(VER2[i]) : 0;
            if (one == two) {
                continue;
            }
            if (one > two) {
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }
}