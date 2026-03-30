class Solution:
    def checkStrings(self, s1: str, s2: str) -> bool:
        return Counter(s1[::2]) == Counter(s2[::2]) and Counter(s1[1::2]) == Counter(s2[1::2])

class Solution1:
    def checkStrings(self, s1: str, s2: str) -> bool:
        group1 = sorted(s1[i] for i in range(0, len(s1), 2))
        group2 = sorted(s1[i] for i in range(1, len(s1), 2))
        group3 = sorted(s2[i] for i in range(0, len(s2), 2))
        group4 = sorted(s2[i] for i in range(1, len(s2), 2))
        return group1 == group3 and group2 == group4
