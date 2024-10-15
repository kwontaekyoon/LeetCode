class Solution:
    def minimumSteps(self, s: str) -> int:
        n = len(s)
        upper_bound = n - 1
        while (upper_bound >= 0 and s[upper_bound] == '1'):
            upper_bound -= 1
        res = 0
        for i in range(upper_bound, -1, -1):
            if s[i] == '1':
                res += upper_bound - i
                upper_bound -= 1
        return res