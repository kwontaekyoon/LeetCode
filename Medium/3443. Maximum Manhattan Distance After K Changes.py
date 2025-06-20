class Solution:
    def maxDistance(self, s: str, k: int) -> int:
        E = W = S = N = 0
        result = 0
        for i, d in enumerate(s):
            if d == 'E':
                E += 1
            elif d == 'W':
                W += 1
            elif d == 'S':
                S += 1
            else:
                N += 1
            x = abs(S - N)
            y = abs(E - W)
            MD = x + y
            MD = MD + min(2 * k, i + 1 - MD)
            result = max(result, MD)
        return result