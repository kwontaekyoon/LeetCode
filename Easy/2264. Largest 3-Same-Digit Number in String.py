class Solution:
    def largestGoodInteger(self, num: str) -> str:
        largest = -1
        curr_num = int(num[0])
        streak = 0
        for c in num:
            digit = int(c)
            if curr_num == digit:
                streak += 1
                if streak > 2:
                    largest = max(largest, digit)
            else:
                curr_num = digit
                streak = 1
        return "" if largest < 0 else str(largest) * 3