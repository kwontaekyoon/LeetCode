import java.util.HashMap;

class Solution {
    public boolean canArrange(int[] arr, int k) {
        final var res = new int[k];
        for (int num : arr) {
            res[((num % k) + k) % k]++;
        }
        if (res[0] % 2 > 0) {
            return false;
        }
        for (int i = 1; i <= k / 2; i++) {
            if (res[i] != res[k - i]) {
                return false;
            }
        }
        return true;
    }
}

class Solution2 {
    public boolean canArrange(int[] arr, int k) {
        final var negRes = new int[k];
        final var posRes = new int[k];
        final var n = arr.length;
        var pairsCnt = 0;
        for (int num : arr) {
            int divNum = num % k;
            if (divNum == 0) {
                if (posRes[0] > 0) {
                    posRes[0]--;
                    pairsCnt++;
                } else {
                    posRes[0]++;
                }
            } else if (divNum > 0) {
                if (negRes[divNum] > 0) {
                    negRes[divNum]--;
                    pairsCnt++;
                } else if (posRes[k - divNum] > 0) {
                    posRes[k - divNum]--;
                    pairsCnt++;
                } else {
                    posRes[divNum]++;
                }
            } else {
                if (posRes[-divNum] > 0) {
                    posRes[-divNum]--;
                    pairsCnt++;
                } else if (negRes[k + divNum] > 0) {
                    negRes[k + divNum]--;
                    pairsCnt++;
                } else {
                    negRes[-divNum]++;
                }
            }
        }
        return pairsCnt == n / 2;
    }
}

class Solution1 {
    public boolean canArrange(int[] arr, int k) {
        final var map = new HashMap<Integer, Integer>();
        for (int num : arr) {
            int dividedNum = num % k;
            int poss1 = -dividedNum;
            int poss1Cnt = map.getOrDefault(poss1, 0);
            if (poss1Cnt == 1) {
                map.remove(poss1);
                continue;
            }
            if (poss1Cnt > 1) {
                map.put(poss1, poss1Cnt - 1);
                continue;
            }
            int poss2 = dividedNum > 0 ? (k - dividedNum) % k : -k - dividedNum;
            int poss2Cnt = map.getOrDefault(poss2, 0);
            if (poss2Cnt == 1) {
                map.remove(poss2);
                continue;
            }
            if (poss2Cnt > 1) {
                map.put(poss2, poss2Cnt - 1);
                continue;
            }
            map.put(dividedNum, map.getOrDefault(dividedNum, 0) + 1);
        }
        return map.isEmpty();
    }
}