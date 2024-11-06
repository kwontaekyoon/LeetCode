from typing import List


class SortingAndBitManipulation:
    def canSortArray(self, nums: List[int]) -> bool:
        sorted_nums = sorted(nums)
        curr_idx = 0
        curr = [nums[0]]
        prev_bits = nums[0].bit_count()
        for i in range(1, len(nums)):
            curr_bits = nums[i].bit_count()
            if curr_bits == prev_bits:
                curr.append(nums[i])
            else:
                if sorted_nums[curr_idx:curr_idx + len(curr)] != sorted(curr):
                    return False
                curr_idx += len(curr)
                curr = [nums[i]]
                prev_bits = curr_bits
        if curr and sorted_nums[curr_idx:curr_idx + len(curr)] != sorted(curr):
            return False
        return True

class BF:
    def canSortArray(self, nums: List[int]) -> bool:
        bit_cnts = []
        for i in range(len(nums)):
            bit_cnts.append(nums[i].bit_count())
            for j in range(i - 1, -1, -1):
                if nums[j] > nums[i] and bit_cnts[j] != bit_cnts[i]:
                    return False
        return True
