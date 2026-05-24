class Solution:
    def maxJumps(self, arr: List[int], d: int) -> int:
        n = len(arr)
        @cache
        def dfs(i: int) -> int:
            best = 1
            # left
            for nxt in range(i - 1, max(-1, i - d - 1), -1):
                if arr[nxt] >= arr[i]:
                    break
                best = max(1 + dfs(nxt), best)
            # right
            for nxt in range(i + 1, min(n, i + d + 1)):
                if arr[nxt] >= arr[i]:
                    break
                best = max(1 + dfs(nxt), best)
            return best
        return max(dfs(i) for i in range(n))
