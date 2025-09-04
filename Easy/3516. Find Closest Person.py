class Solution:
    def findClosest(self, x: int, y: int, z: int) -> int:
        xz, yz = abs(z - x), abs(z - y)
        return 0 if xz == yz else 1 if xz < yz else 2