class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int k = ruleKey.equals("type") ? 0 : ruleKey.equals("color") ? 1 : 2;
        int cnt = 0;
        for (var item : items) {
            cnt += item.get(k).equals(ruleValue) ? 1 : 0;
        }
        return cnt;
    }
}