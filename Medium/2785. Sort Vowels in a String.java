class Solution {
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1) {
                vowels.add(c);
            }
        }
        Collections.sort(vowels, Collections.reverseOrder());

        StringBuilder sortedResult = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1) {
                sortedResult.append(vowels.get(vowels.size() - 1));
                vowels.remove(vowels.size() - 1);
            } else {
                sortedResult.append(c);
            }
        }
        return sortedResult.toString();
    }
}
