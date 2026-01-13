from typing import List


class Solution:
    def separateSquares(self, squares: List[List[int]]) -> float:
        top, mid, bottom = float('-inf'), 0.0, float('inf')
        total_area = 0
        for _, y, l in squares:
            total_area += l * l
            top = max(top, y + l)
            bottom = min(bottom, y)
        half_area = total_area / 2.0
        while top - bottom > 10 ** -5:
            mid = (top + bottom) / 2.0
            curr_area = 0
            for _, y, l in squares:
                curr_area += l * max(0, min(l, mid - y))
            if curr_area < half_area:
                bottom = mid
            else:
                top = mid
        return mid
        
            