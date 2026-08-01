class Solution:
    def predictTheWinner(self, A: List[int]) -> bool:
        @cache
        def dfs(i: int, j: int) -> int:
            if i == j:
                return A[i]
            return max(A[i] - dfs(i + 1, j),
                       A[j] - dfs(i, j - 1))
        return dfs(0, len(A) - 1) >= 0