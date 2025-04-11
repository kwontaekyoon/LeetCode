class EasyBruteForce:
    def countSymmetricIntegers(self, low: int, high: int) -> int:
        result = 0
        for num in range(low, high + 1):
            if 10 < num < 100:
                if num % 11 == 0:
                    result += 1
            elif 1000 < num < 10000:
                if num % 10 + num % 100 // 10 == num % 1000 // 100 + num % 10000 // 1000:
                    result += 1
        return result

class HardDP:
    def countSymmetricRec(self, numStr, idx, n, tight, hasNonZero, isSecondHalf, rem, diff, FirstHalfSum, diffFromLeft, dp):
        # Base Case: When we have processed all digits,
        # check if the number is valid (i.e., non-zero-started and symmetric).
        if idx == n:
            return 1 if (hasNonZero and diff == 0 and rem == 0) else 0
        
        # Get the memoized result for the current state.
        # We add offsets (FirstHalfSum and diffFromLeft) to shift potential negative values to positive indices.
        if dp[idx][tight][hasNonZero][isSecondHalf][rem + FirstHalfSum][diff + diffFromLeft] != -1:
            return dp[idx][tight][hasNonZero][isSecondHalf][rem + FirstHalfSum][diff + diffFromLeft]
        
        # Determine the maximum digit available at this index:
        # If 'tight' is true, the maximum is bound by the current digit in numStr.
        # Otherwise, we can choose any digit from 0 to 9.
        maxDigit = int(numStr[idx]) if tight else 9
        result = 0
        
        # Try every possible digit from 0 to maxDigit at this position.
        for digit in range(maxDigit + 1):
            # Update hasNonZero: becomes true if already true, or if the chosen digit is nonzero.
            newHasNonZero = hasNonZero or (digit != 0)
            # Start with current balance and difference values.
            newRem = rem
            newDiff = diff
            
            # Update the running difference and balance counter based on the current half.
            if isSecondHalf:
                # In the second half, subtract the digit from the running difference.
                newDiff -= digit
                # Also, decrease the balance counter if a nonzero digit has been set.
                if newHasNonZero:
                    newRem -= 1
            else:
                # In the first half, add the digit to the running difference.
                newDiff += digit
                # Increase the balance counter if we've started the number.
                if newHasNonZero:
                    newRem += 1
            
            # Determine if the next state remains tight:
            # It's still tight if we chose the maximum allowed digit.
            newTight = 1 if (tight and (digit == maxDigit)) else 0
            
            # Continue building the number with the chosen digit.
            result += self.countSymmetricRec(numStr, idx + 1, n, newTight, newHasNonZero, isSecondHalf, newRem, newDiff,
                                        FirstHalfSum, diffFromLeft, dp)
            
            # Branch into processing the second half if we are currently in the first half and the number has started.
            if newHasNonZero and not isSecondHalf:
                result += self.countSymmetricRec(numStr, idx + 1, n, newTight, newHasNonZero, 1, newRem, newDiff,
                                            FirstHalfSum, diffFromLeft, dp)
        
        # Save the computed result for this state and return.
        dp[idx][tight][hasNonZero][isSecondHalf][rem + FirstHalfSum][diff + diffFromLeft] = result
        return result
    
    # Counts all symmetric numbers up to 'num'.
    def countUpTo(self, num):
        numStr = str(num)
        n = len(numStr)
        
        # Offsets used to ensure dp table indices are always non-negative.
        FirstHalfSum = n        # Shifts 'rem' range.
        diffFromLeft = 9 * n    # Shifts 'diff' range.
        
        # Initialize 6D DP array with -1
        dp = [[[[[[-1 for _ in range(18 * n + 1)] for _ in range(2 * n + 1)] for _ in range(2)] for _ in range(2)] for _ in range(2)] for _ in range(n + 1)]
        
        # Start recursion from the first digit, with a tight bound (tight = 1),
        # no nonzero digit encountered yet (hasNonZero = 0), and in first half mode (isSecondHalf = 0).
        return self.countSymmetricRec(numStr, 0, n, 1, 0, 0, 0, 0, FirstHalfSum, diffFromLeft, dp)
    
    # To count symmetric integers within the inclusive range [low, high].
    def countSymmetricIntegers(self, low, high):
        # Count symmetric numbers up to 'high' and subtract those up to 'low - 1'.
        return self.countUpTo(high) - self.countUpTo(low - 1)