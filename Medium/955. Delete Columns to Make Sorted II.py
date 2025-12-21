from typing import List


class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        n, m = len(strs), len(strs[0])
        sorted_pairs = [False] * (n - 1)
        count = 0
        for c in range(m):
            bad = False
            for r in range(n - 1):
                if not sorted_pairs[r] and strs[r][c] > strs[r + 1][c]:
                    bad = True
                    break

            if bad:
                count += 1
                continue

            for r in range(n - 1):
                if not sorted_pairs[r] and strs[r][c] < strs[r + 1][c]:
                    sorted_pairs[r] = True

            if all(sorted_pairs):
                break

        return count