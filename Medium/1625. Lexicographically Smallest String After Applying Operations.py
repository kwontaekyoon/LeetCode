class Solution:
    def findLexSmallestString(self, s: str, a: int, b: int) -> str:
        n = len(s)
        incremented = {str(n): str((n + a) % 10) for n in range(10)}
        def add(s: str) -> str:
            return ''.join(s[i] if i % 2 == 0 else incremented[s[i]] for i in range(n))
        def rotate(s: str) -> str:
            return s[n - b:] + s[:n - b]
        seen = set()
        def dfs(s: str) -> None:
            if s in seen:
                return
            seen.add(s)
            dfs(add(s))
            dfs(rotate(s))
        dfs(s)
        return min(seen)