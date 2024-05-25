class Solution {
    public int maxRepeating(String sequence, String word) {
        final int N = sequence.length(), M = word.length();
        int maxRep = 0;
        for (int i = 0; i <= N - M; i++) {
            int rep = 0;
            for (int j = i; j <= N - M && sequence.substring(j, j + M).equals(word); j += M) {
                rep++;
            }
            maxRep = Math.max(maxRep, rep);
        }
        return maxRep;
    }
}