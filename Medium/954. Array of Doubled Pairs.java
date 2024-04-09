class Solution {
    public boolean canReorderDoubled(int[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        var neg = new int[Math.abs(min) + 1];
        var pos = new int[Math.abs(max) + 1];
        for (int num : arr) {
            if (num < 0) {
                neg[-num]++;
            } else {
                pos[num]++;
            }
        }
        return check(neg) && check(pos);
    }

    private boolean check(int[] freq) {
        int n = freq.length;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) {
                continue;
            }
            if (i * 2 >= n || freq[i * 2] < freq[i]) {
                return false;
            }
            freq[i * 2] -= freq[i];
        }
        return true;
    }
}

class UsingQueue {
    public boolean canReorderDoubled(int[] arr) {
        var map = new HashMap<Integer, Integer>();
        var neg = new PriorityQueue<Integer>((x, y) -> Integer.compare(y, x));
        var pos = new PriorityQueue<Integer>((x, y) -> Integer.compare(x, y));
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        if (map.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }
        for (int i : map.keySet()) {
            if (i < 0) {
                neg.offer(i);
            } else {
                pos.offer(i);
            }
        }
        return check(neg, map) && check(pos, map);
    }

    private boolean check(PriorityQueue<Integer> queue, Map<Integer, Integer> map) {
        while (queue.size() > 0) {
            int i = queue.poll();
            if (map.get(i) == 0) {
                continue;
            }
            if (map.getOrDefault(i * 2, 0) < map.get(i)) {
                return false;
            }
            map.put(i * 2, map.get(i * 2) - map.get(i));
        }
        return true;
    }
}