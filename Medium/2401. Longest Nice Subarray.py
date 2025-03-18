from typing import List


class BitManipulation:
    def longestNiceSubarray(self, nums: List[int]) -> int:
        bits = 0
        res = 1
        l = 0
        for r, num in enumerate(nums):
            while bits & num:
                bits ^= nums[l]
                l += 1
            res = max(r - l + 1, res)
            bits |= num
        return res


class BruteForce:
    def longestNiceSubarray(self, nums: List[int]) -> int:
        def update(i: int, increment: bool) -> None:
            num = nums[i]
            idx = 0
            while num > 0:
                bits[idx] += num % 2 * (1 if increment else -1)
                num //= 2
                idx += 1
        n, l = len(nums), 0
        res = 1
        bits = [0 for _ in range(32)]
        for r in range(n):
            update(r, True)
            while not all(bit < 2 for bit in bits):
                update(l, False)
                l += 1
            res = max(r - l + 1, res)
        return res