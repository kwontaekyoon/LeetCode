class Solution {
    public int strStr(String haystack, String needle) {
        char[] B = haystack.toCharArray();
        char[] S = needle.toCharArray();
        int n = B.length, target = S.length;
        for (int i = 0; i < n; i++) {
            if (B[i] == S[0]) {
                int size = 0;
                while (i + size < n && B[i + size] == S[size]) {
                    size += 1;
                    if (size == target) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0, len = needle.length(); i <= haystack.length() - len; i++) {
            if (haystack.substring(i, i + len).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}