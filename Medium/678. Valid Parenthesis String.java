class UsingStack {
    public boolean checkValidString(String s) {
        var opens = new ArrayDeque<Integer>();
        var stars = new ArrayDeque<Integer>();
        var chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                opens.push(i);
            } else if (chars[i] == ')') {
                if (!opens.isEmpty()) {
                    opens.pop();
                } else {
                    if (stars.isEmpty()) {
                        return false;
                    }
                    stars.pop();
                }
            } else {
                stars.push(i);
            }
        }
        while (!opens.isEmpty()) {
            if (stars.isEmpty()) {
                return false;
            }
            if (opens.peek() > stars.peek()) {
                return false;
            }
            opens.pop();
            stars.pop();
        }
        return true;
    }
}

class Greedy {
    public boolean checkValidString(String s) {
        int leftMin = 0, leftMax = 0;
        for (var c : s.toCharArray()) {
            if (c == '(') {
                leftMin++;
                leftMax++;
            } else if (c == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }
            if (leftMax < 0) {
                return false;
            }
            if (leftMin < 0) {
                leftMin = 0;
            }
        }
        return leftMin == 0;
    }
}