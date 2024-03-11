class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> heightToName = new HashMap<>();
        int n = names.length;
        for (int i = 0; i < n; i++) {
            heightToName.put(heights[i], names[i]);
        }
        Arrays.sort(heights);
        for (int i = 0; i < n; i++) {
            names[i] = heightToName.get(heights[n - i - 1]);
        }
        return names;
    }
}