class Math:
    def numberOfPowerfulInt(self, start: int, finish: int, limit: int, s: str) -> int:
        def calculate(x: str) -> int:
            if len(x) < len(s):
                return 0
            if len(x) == len(s):
                return 1 if x >= s else 0

            suffix = x[len(x) - len(s):]
            count = 0
            pre_len = len(x) - len(s)

            for i in range(pre_len):
                if limit < int(x[i]):
                    count += (limit + 1) ** (pre_len - i)
                    return count
                count += int(x[i]) * (limit + 1) ** (pre_len - 1 - i)

            if suffix >= s:
                count += 1

            return count

        return calculate(str(finish)) - calculate(str(start - 1))

class DP:
    def numberOfPowerfulInt(self, start: int, finish: int, limit: int, s: str) -> int:
        def count(val: int) -> int:
            max_val = str(val)
            n = len(max_val) - len(s)
            if n < 0:
                return 0
            dp = [[0] * 2 for _ in range(n + 1)]
            dp[n][0] = 1
            dp[n][1] = int(max_val[n:] >= s)
            for i in range(n - 1, -1, -1):
                digit = int(max_val[i])
                dp[i][0] = (limit + 1) * dp[i + 1][0]
                if digit <= limit:
                    dp[i][1] = digit * dp[i + 1][0] + dp[i + 1][1]
                else:
                    dp[i][1] = (limit + 1) * dp[i + 1][0]
            return dp[0][1]
        return count(finish) - count(start - 1)