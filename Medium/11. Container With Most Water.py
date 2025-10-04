from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        l, r = 0, len(height) - 1
        max_area = -float('inf')
        while l < r:
            if (r - l) * 10000 < max_area:
                break
            max_area = max(max_area, min(height[l], height[r]) * (r - l))
            if height[l] < height[r]:
                l += 1
            else:
                r -= 1
        return max_area # type: ignore