from typing import List


class Solution:
    def sortByBits(self, arr: List[int]) -> List[int]:
        return sorted(arr, key = lambda num: (num.bit_count(), num))

class Solution1:
    def sortByBits(self, arr: List[int]) -> List[int]:
        # print(bin(10000))
        bits = [[] for _ in range(14)]
        for num in arr:
            bit = bin(num).count('1')
            bits[bit].append(num)
        res = []
        for i in range(14):
            res.extend(sorted(bits[i]))
        return res

