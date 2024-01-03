class Solution {
    public int numberOfBeams(String[] bank) {
        int numOfBeams = 0;
        int pre = 0;
        for (String row : bank) {
            int cur = 0;
            for (char c : row.toCharArray()) {
                cur += (c - '0');
            }
            if (cur == 0) {
                continue;
            }
            numOfBeams += (cur * pre);
            pre = cur;
        }
        return numOfBeams;
    }
}