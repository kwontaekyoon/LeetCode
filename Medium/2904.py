class Solution:
    def shortestBeautifulSubstring(self, s: str, k: int) -> str:
        left = ones = 0
        ans = ""
        for right in range(len(s)):
            if s[right] == '1':
                ones += 1
            if ones < k:
                continue
            while ones > k:
                if s[left] == '1':
                    ones -= 1
                left += 1
            while left < right and s[left] == '0':
                left += 1
            cur = s[left:right + 1]
            if ans == "" or len(cur) < len(ans) or (len(cur) == len(ans) and cur < ans):
                ans = cur
        return ans