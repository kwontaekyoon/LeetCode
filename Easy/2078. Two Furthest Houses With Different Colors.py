class Solution1:
    def maxDistance(self, colours: List[int]) -> int:
        n = len(colours)
        for i in range(n - 1, 1, -1):
            for j in range(n - i):
                if colours[j] != colours[j + i]:
                    return i
        return 1

class Solution:
    def maxDistance(self, A: List[int]) -> int:
        n = len(A)
        left, right = 0, n - 1

        for i in range(n):
            if A[i] ^ A[-1]:
                left = i
                break

        for i in range(n - 1, -1, -1):
            if A[i] ^ A[0]:
                right = i
                break

        return max(n - 1 - left, right)
