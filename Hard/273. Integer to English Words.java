import java.util.ArrayDeque;

class Solution1 {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        final var suffix = new String[] { "", "Thousand", "Million", "Billion" };
        final var prefix = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
                "Nineteen" };
        final var prefix2 = new String[] { "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
                "Ninety" };
        final var stack = new ArrayDeque<String>();
        for (int i = 0; num > 0; i++, num /= 1000) {
            final var sb = new StringBuilder();
            int res = num % 1000;
            if (res == 0) {
                continue;
            }
            if (res >= 100) {
                sb.append(prefix[res / 100]).append(" ").append("Hundred");
                res %= 100;
            }
            if (res != 0) {
                sb.append(" ");
                if (res < 20) {
                    sb.append(prefix[res]);
                } else {
                    sb.append(prefix2[res / 10 - 2]);
                    if (res % 10 > 0) {
                        sb.append(" ").append(prefix[res % 10]);
                    }
                }
            }
            sb.append(" ");
            sb.append(suffix[i]);
            stack.push(sb.toString().trim());
        }
        final var res = new StringBuilder(stack.pop());
        while (!stack.isEmpty()) {
            res.append(" ").append(stack.pop());
        }
        return res.toString().trim();
    }
}

class Solution {

    private final String[] belowTwenty = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
            "Nineteen" };
    private final String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety" };

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return helper(num);
    }

    private String helper(int num) {
        StringBuilder result = new StringBuilder();
        if (num < 20) {
            result.append(belowTwenty[num]);
        } else if (num < 100) {
            result.append(tens[num / 10]).append(" ").append(belowTwenty[num % 10]);
        } else if (num < 1000) {
            result.append(helper(num / 100)).append(" Hundred ").append(helper(num % 100));
        } else if (num < 1000000) {
            result.append(helper(num / 1000)).append(" Thousand ").append(helper(num % 1000));
        } else if (num < 1000000000) {
            result.append(helper(num / 1000000)).append(" Million ").append(helper(num % 1000000));
        } else {
            result.append(helper(num / 1000000000)).append(" Billion ").append(helper(num % 1000000000));
        }
        return result.toString().trim();
    }
}