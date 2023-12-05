class Solution {
    public int numberOfMatches(int teamsLeft) {
        int numberOfMatches = 0;
        while (teamsLeft > 1) {
            if (teamsLeft % 2 == 0) {
                teamsLeft = teamsLeft / 2;
                numberOfMatches += teamsLeft;
            } else {
                teamsLeft = (teamsLeft - 1) / 2 + 1;
                numberOfMatches += (teamsLeft - 1);
            }
        }
        return numberOfMatches;
    }
}