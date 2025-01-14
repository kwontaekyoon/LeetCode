from typing import List


class Optimized:
    def findThePrefixCommonArray(self, A: List[int], B: List[int]) -> List[int]:
        s = set()
        res = []
        for i in range(len(A)):
            s.add(A[i])
            s.add(B[i])
            res.append(2 * (i + 1) - len(s))
        return res

class BF:
    def findThePrefixCommonArray(self, A: List[int], B: List[int]) -> List[int]:
        n = len(A)
        aset, bset = set(), set()
        res = [0] * n
        for i in range(n):
            res[i] = res[i - 1]
            if A[i] == B[i]:
                res[i] += 1
            else:
                if A[i] in bset:
                    res[i] += 1
                if B[i] in aset:
                    res[i] += 1
                aset.add(A[i])
                bset.add(B[i])
        return res