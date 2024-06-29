class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        final var map = new ArrayList[n];
        final var res = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
            map[i] = new ArrayList<Integer>();
        }
        for (var e : edges) {
            map[e[0]].add(e[1]);
        }

        for (int i = 0; i < n; i++) {
            dfs(i, i, map, res, new boolean[n]);
        }
        return res;
    }

    private void dfs(
            int curr, int ancestor, List<Integer>[] map,
            List<List<Integer>> res, boolean[] checked) {
        checked[curr] = true;
        for (var next : map[curr]) {
            if (checked[next]) {
                continue;
            }
            res.get(next).add(ancestor);
            dfs(next, ancestor, map, res, checked);
        }
    }
}

class Solution1 {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        final var res = new ArrayList<Set<Integer>>();
        for (int i = 0; i < n; i++) {
            res.add(new HashSet<>());
        }
        final var checked = new boolean[n];
        final var map = new HashMap<Integer, List<Integer>>();
        for (var e : edges) {
            map.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }
        for (int i = 0; i < n; i++) {
            findAncestors(i, map, checked, res);
        }
        final var ans = new ArrayList<List<Integer>>();
        for (var set : res) {
            var list = new ArrayList<>(set);
            Collections.sort(list);
            ans.add(list);
        }
        return ans;
    }

    private Set<Integer> findAncestors(
            int curr, Map<Integer, List<Integer>> map,
            boolean[] checked, List<Set<Integer>> res) {
        if (!map.containsKey(curr) || checked[curr]) {
            return res.get(curr);
        }
        for (var next : map.get(curr)) {
            res.get(curr).add(next);
            res.get(curr).addAll(findAncestors(next, map, checked, res));
        }
        checked[curr] = true;
        return res.get(curr);
    }
}