from typing import List


class String:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        return ''.join('1' if num[i] == '0' else '0' for i, num in enumerate(nums))

class HashTable:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        unique_nums = set(int(''.join(list(num)), 2) for num in nums)
        max_num = 2 ** len(nums[0])
        for i in range(0, max_num):
            if i not in unique_nums:
                res = str(bin(i))[2:]
                return '0' * (len(nums[0]) - len(res)) + res
        return ''