class Solution:
    def maximum69Number (self, num: int) -> int:
        return int(str(num).replace('6', '9', 1))

class Solution1:
    def maximum69Number (self, num: int) -> int:
        digits = list(str(num))
        for i, v in enumerate(digits):
            if v == '6':
                digits[i] = '9'
                break
        return int(''.join(digits))