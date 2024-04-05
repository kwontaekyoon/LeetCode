class Solution {
    public String makeGood(String s) {
        var res = new StringBuilder();
        for (char curr : s.toCharArray()) {
            var size = res.length();
            if (size == 0) {
                res.append(curr);
            } else {
                var prev = res.charAt(size - 1);
                if (Math.abs(prev - curr) == 32) {
                    res.setLength(size - 1);
                } else {
                    res.append(curr);
                }
            }
        }
        return res.toString();
    }
}