from collections import deque
from typing import List


class Optimized:
    def smallestSubarrays(self, nums: List[int]) -> List[int]:
        result = []
        for i, v in enumerate(nums):
            result.append(1)
            j = i - 1
            while j >= 0 and nums[j] | v != nums[j]:
                result[j] = i - j + 1
                nums[j] |= v
                j -= 1
        return result

class ArrayFromTheEnd:
    def smallestSubarrays(self, nums: List[int]) -> List[int]:
        n = len(nums)
        last = [0] * 32
        result = [1] * n
        for i in range(n - 1, -1, -1):
            pos = 0
            while nums[i]:
                if nums[i] & 1:
                    last[pos] = i
                pos += 1
                nums[i] >>= 1
            result[i] = max(result[i], max(last) - i + 1)
        return result

class DequeFromTheStartOfTheArray:
    def smallestSubarrays(self, nums: List[int]) -> List[int]:
        bits_to_deque = []
        for i, v in enumerate(nums):
            bit = 0
            while v:
                if v % 2:
                    while len(bits_to_deque) <= bit:
                        bits_to_deque.append(deque())
                    bits_to_deque[bit].append(i)
                v //= 2
                bit += 1
        result = []
        for i, v in enumerate(nums):
            result.append(1)
            for deq in bits_to_deque:
                while deq and deq[0] < i:
                    deq.popleft()
                if deq:
                    result[-1] = max(result[-1], deq[0] - i + 1)
        return result