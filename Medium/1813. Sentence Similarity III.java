class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        final var firstToWords = sentence1.split(" ");
        final var secondToWords = sentence2.split(" ");
        final var longer = firstToWords.length > secondToWords.length ? firstToWords : secondToWords;
        final int longLen = longer.length;
        final var shorter = firstToWords.length <= secondToWords.length ? firstToWords : secondToWords;
        final int shortLen = shorter.length;
        int prefix = 0, suffix = 0;
        while (prefix < shortLen && longer[prefix].equals(shorter[prefix])) {
            prefix++;
        }
        while (suffix < shortLen - prefix && longer[longLen - 1 - suffix].equals(shorter[shortLen - 1 - suffix])) {
            suffix++;
        }
        return prefix + suffix == shortLen;
    }
}