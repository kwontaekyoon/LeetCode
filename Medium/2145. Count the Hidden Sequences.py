from typing import List


class Solution:
    def numberOfArrays(self, differences: List[int], lower: int, upper: int) -> int:
        window = upper - lower
        curr_val = lower_bound = upper_bound = result = 0
        for diff in differences:
            curr_val += diff
            lower_bound = min(curr_val, lower_bound)
            upper_bound = max(curr_val, upper_bound)
            result = upper_bound - lower_bound
            if result > window:
                return 0
        return window - result + 1