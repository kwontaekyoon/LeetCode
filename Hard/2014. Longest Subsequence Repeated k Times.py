from collections import deque


class Solution:
    def longestSubsequenceRepeatedK(self, s: str, k: int) -> str:
        def isK(sub: str, t: str, k: int) -> bool:
            count = i = 0
            for c in t:
                if c == sub[i]:
                    i += 1
                    if i == len(sub):
                        i = 0
                        count += 1
                        if count == k:
                            return True
            return False

        res = ""
        q = deque([""])
        freq = [0] * 26
        for ch in s:
            freq[ord(ch)-97] += 1
        cand = [chr(i+97) for i, x in enumerate(freq) if x >= k] # valid candidates
        while q:
            curr = q.popleft()
            for ch in cand:
                nxt = curr + ch
                if isK(nxt, s, k):
                    res = nxt
                    q.append(nxt)
        return res