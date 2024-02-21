class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String base = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int s = 1;
        for (int i = 1; i < base.length(); i++) {
            if (base.charAt(i) != base.charAt(i - 1)) {
                sb.append(s);
                sb.append(base.charAt(i - 1));
                s = 1;
            } else {
                s++;
            }
        }
        sb.append(s);
        sb.append(base.charAt(base.length() - 1));
        return sb.toString();
    }
}