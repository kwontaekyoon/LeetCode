class TwoPointers {
    public boolean judgeSquareSum(int target) {
        long l = 0, r = (long) Math.sqrt(target);
        while (l <= r) {
            var curr = l * l + r * r;
            if (curr == target) {
                return true;
            }
            if (curr < target) {
                l++;
            } else {
                r--;
            }
        }
        return false;
    }
}

class HashTable {
    public boolean judgeSquareSum(int c) {
        final var squares = new HashSet<Integer>();
        for (int i = 0; Math.pow(i, 2) <= c; i++) {
            squares.add((int) Math.pow(i, 2));
        }
        for (int i = 0; Math.pow(i, 2) <= c; i++) {
            if (squares.contains(c - (int) Math.pow(i, 2))) {
                return true;
            }
        }
        return false;
    }
}