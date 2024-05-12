class Solution {
    private record Point(int x, int y) {
    }

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        final var queue = new ArrayDeque<Point>();
        queue.offer(new Point(tx, ty));
        while (!queue.isEmpty()) {
            var curr = queue.poll();
            if (curr.x == sx && curr.y == sy) {
                return true;
            }
            if (curr.x < sx || curr.y < sy || curr.x == curr.y) {
                continue;
            }
            if (curr.x > curr.y) {
                int bound = Math.max(sx, curr.y);
                int nextX = curr.x - Math.max(1, (curr.x - bound) / curr.y) * curr.y;
                queue.offer(new Point(nextX, curr.y));
            } else {
                int bound = Math.max(sy, curr.x);
                int nextY = curr.y - Math.max(1, (curr.y - bound) / curr.x) * curr.x;
                queue.offer(new Point(curr.x, nextY));
            }
        }
        return false;
    }
}

class UsingMath {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (sx < tx && sy < ty) {
            if (tx < ty) {
                ty %= tx;
            } else {
                tx %= ty;
            }
        }
        return (sx == tx && sy <= ty && (ty - sy) % sx == 0) ||
                (sy == ty && sx <= tx && (tx - sx) % sy == 0);
    }
}

// TLE
class UsingStack {
    private record Point(int x, int y) {
    }

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        final var set = new HashSet<Point>();
        final var stack = new ArrayDeque<Point>();
        stack.push(new Point(sx, sy));
        while (!stack.isEmpty()) {
            var curr = stack.pop();
            if (!set.add(curr)) {
                continue;
            }
            if (curr.x == tx && curr.y == ty) {
                return true;
            }
            if (curr.x + curr.y <= tx) {
                stack.push(new Point(curr.x + curr.y, curr.y));
            }
            if (curr.x + curr.y <= ty) {
                stack.push(new Point(curr.x, curr.x + curr.y));
            }
        }
        return false;
    }
}