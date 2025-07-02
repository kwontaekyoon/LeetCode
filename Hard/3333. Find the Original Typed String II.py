class Solution:
    def possibleStringCount(self, word: str, k: int) -> int:
        groups = [1]
        for i in range(1, len(word)):
            if word[i] == word[i - 1]:
                groups[-1] += 1
            else:
                groups.append(1)
        total = 1
        for num in groups:
            total *= num
            total %= (10 ** 9 + 7)

        if k <= len(groups):
            return total

        dp = [0] * k
        dp[0] = 1

        for num in groups:
            new_dp = [0] * k
            sum_val = 0
            for s in range(k):
                if s > 0:
                    sum_val += dp[s - 1]
                    sum_val %= (10 ** 9 + 7)
                if s > num:
                    sum_val -= dp[s - num - 1]
                    sum_val %= (10 ** 9 + 7)
                new_dp[s] = sum_val
            dp = new_dp

        invalid = sum(dp[len(groups):k]) % (10 ** 9 + 7)
        return (total - invalid) % (10 ** 9 + 7)