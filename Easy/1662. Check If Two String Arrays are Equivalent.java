class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder first = new StringBuilder();
        for (String word : word1) {
            first.append(word);
        }
        StringBuilder scond = new StringBuilder();
        for (String word : word2) {
            scond.append(word);
        }
        return first.toString().equals(scond.toString());
    }
}

// class Solution {
// public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
// int idx1 = 0, idx2 = 0, charAt1 = 0, charAt2 = 0;
// while (true) {
// if (charAt1 == word1[idx1].length()) {
// idx1 += 1;
// charAt1 = 0;
// }
// if (charAt2 == word2[idx2].length()) {
// idx2 += 1;
// charAt2 = 0;
// }
// if (idx1 == word1.length && idx2 == word2.length) {
// break;
// }
// if (idx1 == word1.length ^ idx2 == word2.length) {
// return false;
// }
// if (word1[idx1].charAt(charAt1) != word2[idx2].charAt(charAt2)) {
// return false;
// }
// charAt1 += 1;
// charAt2 += 1;
// }
// return true;
// }
// }