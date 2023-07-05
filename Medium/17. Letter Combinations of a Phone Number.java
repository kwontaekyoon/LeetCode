class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Arrays.asList();
        }
        List<String> output = new ArrayList<>();
        String[] digitsToChars = new String[digits.length()];
        int idx = 0;
        for (char c : digits.toCharArray()) {
            if (c == '2') {
                digitsToChars[idx++] = "abc";
            } else if (c == '3') {
                digitsToChars[idx++] = "def";
            } else if (c == '4') {
                digitsToChars[idx++] = "ghi";
            } else if (c == '5') {
                digitsToChars[idx++] = "jkl";
            } else if (c == '6') {
                digitsToChars[idx++] = "mno";
            } else if (c == '7') {
                digitsToChars[idx++] = "pqrs";
            } else if (c == '8') {
                digitsToChars[idx++] = "tuv";
            } else if (c == '9') {
                digitsToChars[idx++] = "wxyz";
            }
        }
        makeCombs(0, "", output, digitsToChars);
        return output;
    }

    public void makeCombs(int idx, String output, List<String> answer, String[] digitsToChars) {
        if (idx == digitsToChars.length) {
            answer.add(output);
        } else {
            for (int i = 0; i < digitsToChars[idx].length(); i++) {
                makeCombs(idx + 1, output + digitsToChars[idx].charAt(i), answer, digitsToChars);
            }
        }
    }
}