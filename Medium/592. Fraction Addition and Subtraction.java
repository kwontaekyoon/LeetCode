class Solution {
    public String fractionAddition(String expression) {
        final var n = expression.length();
        final var cnt = new int[11];
        int i = 0;
        if (expression.charAt(0) != '-') {
            if (expression.charAt(1) == '/') {
                int top = expression.charAt(0) - '0';
                if (n > 3 && Character.isDigit(expression.charAt(3))) {
                    cnt[10] += top;
                    i = 4;
                } else {
                    cnt[expression.charAt(2) - '0'] += top;
                    i = 3;
                }
            } else {
                int top = 10;
                cnt[expression.charAt(3) - '0'] += top;
                i = 4;
            }
        }
        while (i < n) {
            int newTop = expression.charAt(i) == '-' ? -1 : 1;
            if (expression.charAt(i + 2) == '/') {
                newTop *= expression.charAt(i + 1) - '0';
                if (i + 4 < n && Character.isDigit(expression.charAt(i + 4))) {
                    cnt[10] += newTop;
                    i += 5;
                } else {
                    cnt[expression.charAt(i + 3) - '0'] += newTop;
                    i += 4;
                }
            } else {
                newTop *= 10;
                cnt[expression.charAt(i + 4) - '0'] += newTop;
                i += 5;
            }
        }
        int top = cnt[1], bot = 1;
        for (i = 2; i <= 10; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            int newTop = cnt[i];
            int newBot = i;
            top = top * newBot + newTop * bot;
            bot = bot * newBot;
            int gcd = gcd(top, bot);
            top /= gcd;
            bot /= gcd;
        }
        return top + "/" + bot;
    }

    public int gcd(int number1, int number2) {
        if (number1 == 0 || number2 == 0) {
            return number1 + number2;
        } else {
            int absNumber1 = Math.abs(number1);
            int absNumber2 = Math.abs(number2);
            int biggerValue = Math.max(absNumber1, absNumber2);
            int smallerValue = Math.min(absNumber1, absNumber2);
            return gcd(biggerValue % smallerValue, smallerValue);
        }
    }
}
