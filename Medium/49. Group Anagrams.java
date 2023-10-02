class Solution {
    private String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();
        for (String str : strs) {
            String sortedStr = sortString(str);
            hm.putIfAbsent(sortedStr, new ArrayList<>());
            hm.get(sortedStr).add(str);
        }
        return new ArrayList<>(hm.values());
    }
}