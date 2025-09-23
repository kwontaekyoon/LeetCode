class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        v1, v2 = list(map(int, version1.split('.'))), list(map(int, version2.split('.')))
        while v1 and v1[-1] == 0:
            v1.pop()
        while v2 and v2[-1] == 0:
            v2.pop()
        while v1 and v2:
            n1, n2 = v1.pop(0), v2.pop(0)
            if n1 > n2:
                return 1
            if n2 > n1:
                return -1
        if v1:
            return 1
        if v2:
            return -1
        return 0