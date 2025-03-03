from typing import List


class TwoPointers:
    def pivotArray(self, nums: List[int], pivot: int) -> List[int]:
        n = len(nums)
        res = [pivot] * n
        left, right = 0, n - 1
        for i in range(n):
            if nums[i] < pivot:
                res[left] = nums[i]
                left += 1
        for j in range(n - 1, -1, -1):
            if nums[j] > pivot:
                res[right] = nums[j]
                right -= 1
        return res


class BruteForce:
    def pivotArray(self, nums: List[int], pivot: int) -> List[int]:
        left, mid, right = [], [], []
        for num in nums:
            if num > pivot:
                right.append(num)
            elif num < pivot:
                left.append(num)
            else:
                mid.append(num)
        return left + mid + right