class romanToInt {
    public int romanToInt(String s) {
        int[] L = new int[s.length()];
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'M') {
                L[i] = 1000;
            } else if (c == 'D') {
                L[i] = 500;
            } else if (c == 'C') {
                L[i] = 100;
            } else if (c =='L') {
                L[i] = 50;
            } else if (c == 'X') {
                L[i] = 10;
            } else if (c == 'V') {
                L[i] = 5;
            } else {
                L[i] = 1;
            }
        }
        for (int i = L.length - 1; i > -1; i--) {
            if (i == L.length - 1) {
                answer += L[i];
            } else {
                if (L[i] >= L[i + 1]) {
                    answer += L[i];
                } else {
                    answer -= L[i];
                }
            }
        }
        return answer;
    }
}