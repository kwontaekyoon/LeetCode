from typing import List


class Solution:
    def maximumDifference(self, nums: List[int]) -> int:
        smallest = float('inf')
        result = -1
        for num in nums:
            if num <= smallest:
                smallest = num
            else:
                result = max(result, num - smallest)
        return result # type: ignore

class Stack:
    def maximumDifference(self, nums: List[int]) -> int:
        stack = []
        result = -1
        for num in nums:
            while stack and stack[-1] >= num:
                stack.pop()        
            if stack:
                result = max(result, num - stack[0])
            stack.append(num)
        return result