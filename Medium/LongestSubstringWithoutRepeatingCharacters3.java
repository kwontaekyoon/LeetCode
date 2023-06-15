class Solution {
    public int lengthOfLongestSubstring(String s) {
        String slide = "";
        int answer = -1;
        if (s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        for (char c : s.toCharArray()) {
            String current = String.valueOf(c);
            if (slide.contains(current)) {
                slide = slide.substring(slide.indexOf(current) + 1);
            }
            slide = slide + String.valueOf(c);
            answer = Math.max(slide.length(), answer);
        }
        return answer;
    }
}