import java.util.Arrays;

class Solution {
    public int findTheLongestSubstring(String s) {
        final var chars = s.toCharArray();
        final int n = chars.length;
        final var map = new int[32];
        int res = 0;
        for (int i = 0, p = 0; i < n; i++) {
            if (chars[i] == 'a') {
                p ^= 1;
            } else if (chars[i] == 'e') {
                p ^= 2;
            } else if (chars[i] == 'i') {
                p ^= 4;
            } else if (chars[i] == 'o') {
                p ^= 8;
            } else if (chars[i] == 'u') {
                p ^= 16;
            }
            if (p == 0) {
                res = i + 1;
            }
            map[p] = i;
        }
        for (int i = 0, p = 0; i < n; i++) {
            if (chars[i] == 'a') {
                p ^= 1;
            } else if (chars[i] == 'e') {
                p ^= 2;
            } else if (chars[i] == 'i') {
                p ^= 4;
            } else if (chars[i] == 'o') {
                p ^= 8;
            } else if (chars[i] == 'u') {
                p ^= 16;
            }
            res = Math.max(res, map[p] - i);
        }
        return res;
    }
}

// O(n ^ 2)
class BruteForce {
    public int findTheLongestSubstring(String s) {
        final var vowelsCnt = new int[5];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            final var c = s.charAt(i);
            if (c == 'a') {
                vowelsCnt[0]++;
            } else if (c == 'e') {
                vowelsCnt[1]++;
            } else if (c == 'i') {
                vowelsCnt[2]++;
            } else if (c == 'o') {
                vowelsCnt[3]++;
            } else if (c == 'u') {
                vowelsCnt[4]++;
            }
            if (isValid(vowelsCnt)) {
                res = Math.max(res, i + 1);
                continue;
            }
            final var tmpCnt = Arrays.copyOf(vowelsCnt, 5);
            for (int j = 0; j < i; j++) {
                final var r = s.charAt(j);
                if (r == 'a') {
                    tmpCnt[0]--;
                } else if (r == 'e') {
                    tmpCnt[1]--;
                } else if (r == 'i') {
                    tmpCnt[2]--;
                } else if (r == 'o') {
                    tmpCnt[3]--;
                } else if (r == 'u') {
                    tmpCnt[4]--;
                }
                if (isValid(tmpCnt)) {
                    res = Math.max(res, i - j);
                    break;
                }
            }
        }
        return res;
    }

    private boolean isValid(int[] cnt) {
        for (int c : cnt) {
            if (c % 2 > 0) {
                return false;
            }
        }
        return true;
    }
}