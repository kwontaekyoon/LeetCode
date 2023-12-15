class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> from = new HashSet<>();
        Set<String> toto = new HashSet<>();
        for (List<String> path : paths) {
            from.add(path.get(0));
            toto.add(path.get(1));
        }
        for (String dest : toto) {
            if (!from.contains(dest)) {
                return dest;
            }
        }
        return null;
    }
}