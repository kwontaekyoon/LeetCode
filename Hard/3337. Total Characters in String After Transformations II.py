from typing import List


class Solution:
    MOD = 10 ** 9 + 7

    def multiplyMatrices(self, A, B):
        rowsA, colsA, colsB = len(A), len(A[0]), len(B[0])
        result = [[0] * colsB for _ in range(rowsA)]
        for i in range(rowsA):
            for j in range(colsB):
                tmp = 0
                for k in range(colsA):
                    tmp += A[i][k] * B[k][j]
                result[i][j] = tmp % self.MOD
        return result

    def powerMatrix(self, matrix, exponent):
        n = len(matrix)
        result = [[1 if i == j else 0 for j in range(n)] for i in range(n)]
        while exponent > 0:
            if exponent & 1:
                result = self.multiplyMatrices(result, matrix)
            matrix = self.multiplyMatrices(matrix, matrix)
            exponent >>= 1
        return result

    def lengthAfterTransformations(self, s: str, t: int, nums: List[int]) -> int:
        transform = [[0] * 26 for _ in range(26)]
        for i in range(26):
            for j in range(nums[i]):
                transform[i][(i + 1 + j) % 26] += 1
        transform = self.powerMatrix(transform, t)
        freq = [[0] * 26]
        for ch in s:
            freq[0][ord(ch) - ord('a')] += 1
        freq = self.multiplyMatrices(freq, transform)
        return sum(freq[0]) % self.MOD

class TLE:
    def lengthAfterTransformations(self, s: str, t: int, nums: List[int]) -> int:
        freqs = [0] * 26
        for c in s:
            freqs[ord(c) - ord('a')] += 1
        for _ in range(t):
            new_freqs = [0] * 26
            for i in range(26):
                if not freqs[i]:
                    continue
                for j in range(nums[i]):
                    new_freqs[(i + 1 + j) % 26] += freqs[i]
            freqs = new_freqs
        return sum(freqs) % (10 ** 9 + 7)