// class Solution {
//     public int countCharacters(String[] words, String chars) {
//         Map<Character, Integer> charToFreq = new HashMap<>();
//         for (char c : chars.toCharArray()) {
//             charToFreq.put(c, charToFreq.getOrDefault(c, 0) + 1);
//         }
//         int cnt = 0;
//         out: for (String word : words) {
//             Map<Character, Integer> temp = new HashMap<>();
//             for (char c : word.toCharArray()) {
//                 int i = temp.getOrDefault(c, 0) + 1;
//                 if (i > charToFreq.getOrDefault(c, 0)) {
//                     continue out;
//                 }
//                 temp.put(c, i);
//             }
//             cnt += word.length();
//         }
//         return cnt;
//     }
// }

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] counts = new int[26];
        for (char c : chars.toCharArray()) {
            counts[c - 'a']++;
        }
        int res = 0;
        for (String s : words) {
            res += canForm(s, counts) ? s.length() : 0;
        }
        return res;
    }

    boolean canForm(String word, int[] counts) {
        int[] tmp = new int[26];
        for (char c : word.toCharArray()) {
            int x = c - 'a';
            tmp[x]++;
            if (tmp[x] > counts[x]) {
                return false;
            }
        }
        return true;
    }
}