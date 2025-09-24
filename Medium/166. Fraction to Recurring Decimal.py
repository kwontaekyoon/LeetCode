class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        if numerator % denominator == 0:
            return str(numerator // denominator)
        fraction = []
        if (numerator < 0) ^ (denominator < 0):
            fraction.append('-')
        dividend = abs(numerator)
        divisor = abs(denominator)
        fraction.append(str(dividend // divisor))
        remainder = dividend % divisor
        fraction.append('.')
        remainder_to_idx = {}
        while remainder:
            if remainder in remainder_to_idx:
                fraction.insert(remainder_to_idx[remainder], '(')
                fraction.append(')')
                break
            remainder_to_idx[remainder] = len(fraction)
            remainder *= 10
            fraction.append(str(remainder // divisor))
            remainder %= divisor
        return ''.join(fraction)