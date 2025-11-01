class Solution:
    def smallestNumber(self, n: int) -> int:
        set_bit = 1
        while set_bit < n:
            set_bit *= 2
            set_bit += 1
        return set_bit