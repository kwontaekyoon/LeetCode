class Solution {
    public int leastInterval(char[] tasks, int n) {
        var mp = new int[26];
        for (var t : tasks) {
            mp[t - 'A']++;
        }
        var pq = new PriorityQueue<Integer>((x, y) -> Integer.compare(y, x));
        for (var i : mp) {
            if (i > 0) {
                pq.offer(i);
            }
        }
        var time = 0;
        while (pq.size() > 0) {
            var left = new ArrayList<Integer>();
            var cycle = n + 1;
            while (cycle > 0 && pq.size() > 0) {
                var cur = pq.poll();
                if (cur > 1) {
                    left.add(cur - 1);
                }
                time++;
                cycle--;
            }
            pq.addAll(left);
            if (pq.size() == 0) {
                break;
            }
            time += cycle;
        }
        return time;
    }
}