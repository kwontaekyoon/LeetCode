class Solution {
    public String rankTeams(String[] votes) {
        final var map = new HashMap<Character, int[]>();
        final var N = votes[0].length();
        for (var vote : votes) {
            for (int i = 0; i < N; i++) {
                map.computeIfAbsent(vote.charAt(i), k -> new int[N])[i]++;
            }
        }
        final var teams = new Character[N];
        for (int i = 0; i < N; i++) {
            teams[i] = votes[0].charAt(i);
        }
        Arrays.sort(teams, (x, y) -> {
            int[] X = map.get(x), Y = map.get(y);
            for (int i = 0; i < N; i++) {
                if (X[i] != Y[i]) {
                    return Y[i] - X[i];
                }
            }
            return x - y;
        });
        final var sb = new StringBuilder();
        for (var team : teams) {
            sb.append(team);
        }
        return sb.toString();
    }
}