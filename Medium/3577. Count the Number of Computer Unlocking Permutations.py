class Solution:
    def countPermutations(self, complexity: List[int]) -> int:
        MOD = 10 ** 9 + 7
        n = len(complexity)
        first = complexity[0]
        for i in range(1, n):
            if complexity[i] <= first:
                return 0
        fact = 1
        for i in range(2, n):
            fact = (fact * i) % MOD
        return fact