MOD, MAX = 1000000007, 100001
POW = [1] * MAX
for i in range(1, MAX):
    POW[i] = (POW[i - 1] * 10) % MOD

class Solution:
    def sumAndMultiply(self, s: str, queries: list[list[int]]) -> list[int]:
        n, res = len(s), []
        A, B, Len = [[0] * (n + 1) for _ in range(3)]

        for i in range(n):
            d = int(s[i])
            A[i + 1] = A[i] + d
            B[i + 1] = (B[i] * 10 + d) % MOD if d else B[i]
            Len[i + 1] = Len[i] + (d > 0)

        res = []

        for l, r in queries:
            r += 1

            sub = (B[l] * POW[Len[r] - Len[l]]) % MOD
            x = (B[r] - sub) % MOD

            res.append((x * (A[r] - A[l])) % MOD)

        return res

class Solution1:
    def sumAndMultiply(self, s: str, queries: List[List[int]]) -> List[int]:
        MOD = 1000000007
        prefix_sum = [0]
        prefix_num = [0]
        for c in s:
            c = int(c)
            prefix_sum.append((prefix_sum[-1] + c) % MOD)
            if c:
                prefix_num.append((prefix_num[-1] * 10 + c) % MOD)
            else:
                prefix_num.append(prefix_num[-1])
        res = []
        for l, r in queries:
            summ = prefix_sum[r + 1] - prefix_sum[l]
            numm = prefix_num[r + 1]
            if prefix_num[l]:
                numm %= 10 ** (int(math.log10(prefix_num[r + 1])) - int(math.log10(prefix_num[l])))
            res.append(summ * numm % MOD)
        return res
