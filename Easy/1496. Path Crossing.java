class Solution {
    public boolean isPathCrossing(String path) {
        Set<List<Integer>> visited = new HashSet<>();
        int x = 0, y = 0;
        visited.add(List.of(x, y));
        for (char dir : path.toCharArray()) {
            if (dir == 'E') {
                x += 1;
            } else if (dir == 'W') {
                x -= 1;
            } else if (dir == 'S') {
                y -= 1;
            } else if (dir == 'N') {
                y += 1;
            }
            if (!visited.add(List.of(x, y))) {
                return true;
            }
        }
        return false;
    }
}