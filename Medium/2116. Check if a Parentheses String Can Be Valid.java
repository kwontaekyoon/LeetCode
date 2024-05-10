class Optimized {
    public boolean canBeValid(String s, String locked) {
        final int N = s.length();
        if (N % 2 > 0) {
            return false;
        }
        int minBal = 0, maxBal = 0;
        for (int i = 0; i < N; i++) {
            if (locked.charAt(i) == '0') {
                minBal--;
                maxBal++;
            } else {
                if (s.charAt(i) == '(') {
                    minBal++;
                    maxBal++;
                } else {
                    minBal--;
                    maxBal--;
                }
            }
            if (minBal < 0) {
                minBal = 0;
            }
            if (maxBal < 0) {
                return false;
            }
        }
        return minBal == 0;
    }
}

class Greedy {
    public boolean canBeValid(String s, String locked) {
        final var N = s.length();
        if (N % 2 > 0) {
            return false;
        }
        int balance = 0, joker = 0;
        for (int i = 0; i < N; i++) {
            if (locked.charAt(i) == '0') {
                joker++;
            } else {
                balance += s.charAt(i) == '(' ? 1 : -1;
            }
            if (balance < 0 && joker + balance < 0) {
                return false;
            }
        }
        balance = 0;
        joker = 0;
        for (int i = N - 1; i > -1; i--) {
            if (locked.charAt(i) == '0') {
                joker++;
            } else {
                balance += s.charAt(i) == ')' ? 1 : -1;
            }
            if (balance < 0 && joker + balance < 0) {
                return false;
            }
        }
        return true;
    }

}