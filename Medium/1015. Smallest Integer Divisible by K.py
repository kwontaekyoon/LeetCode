class Solution1:
    def smallestRepunitDivByK(self, k: int) -> int:
        if k % 2 == 0 or k % 5 == 0:
            return -1
        rem = 1 % k
        size = 1
        while rem:
            rem = (rem * 10 + 1) % k
            size += 1
        return size
    
class Solution:
    def smallestRepunitDivByK(self, k: int) -> int:
        rem = 1 % k
        size = 1
        rem_set = set([rem])
        while rem:
            rem = (rem * 10 + 1) % k
            if rem in rem_set:
                return -1
            rem_set.add(rem)
            size += 1
        return size