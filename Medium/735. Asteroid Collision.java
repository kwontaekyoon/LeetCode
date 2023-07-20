class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid < 0) { // if negative
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                } else {
                    while (true) {
                        if (stack.isEmpty()) {
                            stack.push(asteroid);
                            break;
                        } else {
                            if (stack.peek() < 0) {
                                stack.push(asteroid);
                                break;
                            } else {
                                if (stack.peek() + asteroid == 0) {
                                    stack.pop();
                                    break;
                                } else if (stack.peek() + asteroid < 0) {
                                    stack.pop();
                                    continue;
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
            } else { // if positive
                stack.push(asteroid);
            }
        }
        int[] answer = new int[stack.size()];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }
        return answer;
    }
}