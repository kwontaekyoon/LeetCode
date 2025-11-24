from typing import List


class DP:
    def maxSumDivThree(self, nums: List[int]) -> int:
        dp = [0, 0, 0]
        for num in nums:
            for curr_max in list(dp):
                dp[(curr_max + num) % 3] = max(dp[(curr_max + num) % 3], curr_max + num)
        return dp[0]

class Greedy:
    def maxSumDivThree(self, nums: List[int]) -> int:
        result = sum(nums)
        smallest_one = second_smallest_one = max(nums) + 1
        smallest_two = second_smallest_two = max(nums) + 1
        for num in nums:
            if num % 3 == 1:
                if num < smallest_one:
                    second_smallest_one = smallest_one
                    smallest_one = num
                elif num < second_smallest_one:
                    second_smallest_one = num
            elif num % 3 == 2:
                if num < smallest_two:
                    second_smallest_two = smallest_two
                    smallest_two = num
                elif num < second_smallest_two:
                    second_smallest_two = num
        if result % 3 == 0:
            return result
        if result % 3 == 1:
            if smallest_one < smallest_two + second_smallest_two:
                return result - smallest_one
            return result - smallest_two - second_smallest_two
        if result % 3 == 2:
            if smallest_two < smallest_one + second_smallest_one:
                return result - smallest_two
            return result - smallest_one - second_smallest_one