// sliding window, two pointer
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int i = 0;
        int j = 0;
        int output = Integer.MIN_VALUE;
        int t = 0;
        int f = 0;
        while (j < answerKey.length()) {
            if (answerKey.charAt(j) == 'T') {
                t++;
            } else {
                f++;
            }
            while (t > k && f > k) {
                if (answerKey.charAt(i) == 'T') {
                    t--;
                } else {
                    f--;
                }
                i++;
            }
            output = Math.max(output, j - i + 1);
            j++;
        }
        return output;
    }
}
