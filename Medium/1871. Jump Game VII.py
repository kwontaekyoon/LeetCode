class Solution:
    def canReach(self, s: str, minJump: int, maxJump: int) -> bool:
        n = len(s)
        if s[-1] == '1':
            return False
        dp = [True] + [False] * (n - 1)
        reach, maxR = 0, maxJump
        for i in range(minJump, n):
            if i > maxR:
                return False
            reach += dp[i - minJump]
            if i > maxJump:
                reach -= dp[i - maxJump - 1]
            if reach > 0 and s[i] == '0':
                dp[i] = True
                maxR = i + maxJump
        return reach > 0
