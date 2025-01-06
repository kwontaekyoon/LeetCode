from typing import List


class Solution:
    def minOperations(self, boxes: str) -> List[int]:
        n = len(boxes)
        ops = 0
        balls = [int(num) for num in boxes]
        res = [0] * n
        for i in range(1, n):
            ops += balls[i - 1]
            res[i] += ops
            balls[i] += balls[i - 1]
        balls = [int(num) for num in boxes]
        ops = 0
        for i in range(n - 2, -1, -1):
            ops += balls[i + 1]
            res[i] += ops
            balls[i] += balls[i + 1]
        return res 