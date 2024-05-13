class Solution {
    public String multiply(String num1, String num2) {
        final int M = num1.length(), N = num2.length();
        final var pos = new int[M + N];
        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        final var sb = new StringBuilder();
        for (int p : pos) {
            if (sb.length() > 0 || p > 0) {
                sb.append(p);
            }
        }
        return sb.length() > 0 ? sb.toString() : "0";
    }
}