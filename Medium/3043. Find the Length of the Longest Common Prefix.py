class Solution:
    def longestCommonPrefix(self, arr1: List[int], arr2: List[int]) -> int:
        prefixs = set()
        for num in arr1:
            while num and num not in prefixs:
                prefixs.add(num)
                num //= 10
        result = 0
        for num in arr2:
            while num and num not in prefixs:
                num //= 10
            if num:
                result = max(len(str(num)), result)
        return result
