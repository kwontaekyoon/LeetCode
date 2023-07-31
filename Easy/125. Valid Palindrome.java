class Solution {
    private boolean isAlphabet(char c) {
        return (c - 'a' >= 0 && c - 'z' <= 0) || (c - '0' >= 0 && c - '9' <= 0);
    }

    public boolean isPalindrome(String s) {
        List<Character> list = new ArrayList<>();
        for (char c : s.toLowerCase().toCharArray()) {
            if (isAlphabet(c))
                list.add(c);
        }
        int left = 0, right = list.size() - 1;
        while (left < right) {
            if (list.get(left) == list.get(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}