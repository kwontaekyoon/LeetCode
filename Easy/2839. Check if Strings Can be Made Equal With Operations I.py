class Solution:
    def canBeEqual(self, s1: str, s2: str) -> bool:
        pair1 = sorted([s1[0], s1[2]])
        pair3 = sorted([s2[0], s2[2]])
        if pair1 != pair3:
            return False
        pair2 = sorted([s1[1], s1[3]])
        pair4 = sorted([s2[1], s2[3]])
        return pair2 == pair4
