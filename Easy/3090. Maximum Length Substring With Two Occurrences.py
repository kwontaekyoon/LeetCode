class Solution:
    def maximumLengthSubstring(self, s: str) -> int:
        mapp = defaultdict(int)
        res = l = 0
        for r in range(len(s)):
            mapp[s[r]] += 1
            while mapp[s[r]] > 2:
                mapp[s[l]] -= 1
                l += 1
            res = max(r - l + 1, res)
        return res
        
class Solution1:
    def maximumLengthSubstring(self, s: str) -> int:
        res = l = 0
        count = [0] * 26
        for r in range(len(s)):
            i = ord(s[r]) - ord('a')
            count[i] += 1
            while count[i] > 2:
                j = ord(s[l]) - ord('a')
                count[j] -= 1
                l += 1
            res = max(r - l + 1, res)
        return res