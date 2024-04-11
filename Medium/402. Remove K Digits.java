class Solution {
    public String removeKdigits(String num, int k) {
        var res = new StringBuilder();
        for (var c : num.toCharArray()) {
            while (!res.isEmpty() && res.charAt(res.length() - 1) > c && k > 0) {
                res.setLength(res.length() - 1);
                k--;
            }
            res.append(c);
        }
        int n = res.length() - k;
        for (int i = 0; i < n; i++) {
            if (res.charAt(i) != '0') {
                return res.substring(i, n).toString();
            }
        }
        return "0";
    }
}