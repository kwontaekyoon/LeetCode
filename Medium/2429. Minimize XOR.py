class Solution:
    def minimizeXor(self, num1: int, num2: int) -> int:
        # place bit 1 from num2 to num1 from the highest bit
        # use rest of bit 1 from num2 from the smallest bit
        bits1, bits2 = num1.bit_count(), num2.bit_count()
        if bits1 == bits2:
            return num1
        if bits1 > bits2:
            res = num1
            remove = bits1 - bits2
            x = 1
            while remove > 0:
                if res & x:
                    res ^= x
                    remove -= 1
                x <<= 1
            return res
        if bits1 < bits2:
            res = num1
            add = bits2 - bits1
            x = 1
            while add > 0:
                if not res & x:
                    res |= x
                    add -= 1
                x <<= 1
            return res