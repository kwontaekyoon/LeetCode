class Solution {
    public int minSwaps(String s) {
        int open = 0, unbalanced = 0;
        for (var c : s.toCharArray()) {
            if (c == '[') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    unbalanced++;
                }
            }
        }
        return (unbalanced + 1) / 2;
    }
}

class Solution1 {
    public int minSwaps(String s) {
        final var brackets = s.toCharArray();
        final int n = brackets.length;
        int l = 0, r = n - 1, balance = 0, swap = 0;
        while (l < r) {
            if (brackets[l] == '[') {
                balance++;
            } else {
                if (balance > 0) {
                    balance--;
                } else {
                    while (r > l) {
                        if (brackets[r] == '[') {
                            swap(brackets, l, r);
                            swap++;
                            balance++;
                            break;
                        }
                        r--;
                    }
                }
            }
            l++;
        }
        return swap;
    }

    private void swap(char[] brackets, int l, int r) {
        final var tmp = brackets[l];
        brackets[l] = brackets[r];
        brackets[r] = tmp;
    }
}