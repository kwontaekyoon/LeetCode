class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        req = 1 << k
        seen = [False] * req
        mask = req - 1
        h = 0
        for i, c in enumerate(s):
            h = ((h << 1) & mask) | (ord(c) & 1)
            if i < k - 1:
                continue
            if not seen[h]:
                seen[h] = True
                req -= 1
                if req == 0:
                    return True
        return False