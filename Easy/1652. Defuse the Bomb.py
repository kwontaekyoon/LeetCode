from typing import List


class Solution:
    def decrypt(self, code: List[int], k: int) -> List[int]:
        n = len(code)
        if k == 0:
            return [0] * n
        prefix_sum = sum(code[i] for i in range(k, 0, -1 if k > 0 else 1))
        res = []
        for i in range(n):
            res.append(prefix_sum)
            prefix_sum -= code[(i + 1) % n] if k > 0 else code[i + k]
            prefix_sum += code[i] if k < 0 else code[(i + k + 1) % n]
        return res