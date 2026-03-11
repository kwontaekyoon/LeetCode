class Solution:
    def bitwiseComplement(self, n: int) -> int:
        if n == 0:
            return 1
        bit_size = n.bit_length()
        mask = (1 << bit_size) - 1
        return mask - n