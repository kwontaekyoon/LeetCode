from typing import List


class Solution1:
    def plusOne(self, digits: List[int]) -> List[int]:
        carry = 1
        result = []
        for digit in digits[::-1]:
            num = digit + carry
            result.append(num % 10)
            carry = num // 10
        if carry > 0:
            result.append(carry)
        return result[::-1]

class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        i = len(digits) - 1
        while i >= 0 and digits[i] == 9:
            digits[i] = 0
            i -= 1
        
        if i >= 0:
            digits[i] += 1
        else:
            digits.insert(0, 1)
        
        return digits    