from typing import List


class Solution:
    def divideString(self, s: str, k: int, fill: str) -> List[str]:
        n = len(s)
        result = []
        i = 0
        while i < n:
            result.append(s[i:i+k])
            i += k
        result[-1] += fill * (k - len(result[-1]))
        return result