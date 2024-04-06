class NoStack {
    public String minRemoveToMakeValid(String s) {
        var chars = s.toCharArray();
        int n = chars.length, c = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') {
                c++;
            } else if (chars[i] == ')') {
                if (c > 0) {
                    c--;
                } else {
                    chars[i] = '£';
                }
            }
        }
        for (int i = n - 1; i > -1 && c > 0; i--) {
            if (chars[i] == '(') {
                chars[i] = '£';
                c--;
            }
        }
        var res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (chars[i] != '£') {
                res.append(chars[i]);
            }
        }
        return res.toString();
    }
}

class UsingStack {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        var chars = s.toCharArray();
        var stack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') {
                chars[i] = '£';
                stack.push(i);
            } else if (chars[i] == ')') {
                if (stack.isEmpty()) {
                    chars[i] = '£';
                } else {
                    chars[stack.pop()] = '(';
                }
            } 
        }
        var sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (chars[i] != '£') {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}