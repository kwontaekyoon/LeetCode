from typing import List


class Solution:
    def generate(self, n: int) -> List[List[int]]:
        prev = [1]
        result = [prev]
        for i in range(1, n):
            curr = [1]
            for j in range(1, (i + 1) // 2):
                curr.append(prev[j - 1] + prev[j])
            curr += curr[::-1] if i % 2 else ([prev[i // 2] + prev[i // 2 - 1]] + curr[::-1])
            result.append(curr)
            prev = curr
        return result

class Solution1:
    def generate(self, n: int) -> List[List[int]]:
        result = [[1] for _ in range(n)]
        for i in range(1, n):
            curr = result[i]
            prev = result[i - 1]
            for j in range(1, len(prev)):
                curr.append(prev[j - 1] + prev[j])
            curr.append(1)
        return result