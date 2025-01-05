from itertools import accumulate
from typing import List


class Solution:
    def shiftingLetters(self, s: str, shifts: List[List[int]]) -> str:
        n, sz= len(s), len(shifts)
        app=[0]*(n+1)
        for b, e, d in shifts:
            app[b]+=(d*2-1)
            app[e+1]-=(d*2-1)
        app=list(accumulate(app))
        s0=[]
        for i, c in enumerate(s):
            s0.append(chr((ord(c) + app[i] - 97) % 26 + 97))
        return "".join(s0)