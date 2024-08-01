class Solution {
    public int countSeniors(String[] details) {
        int cnt = 0;
        for (var code : details) {
            if (code.charAt(11) < '6' || (code.charAt(11) == '6' && code.charAt(12) == '0')) {
                continue;
            }
            cnt++;
        }
        return cnt;
    }
}