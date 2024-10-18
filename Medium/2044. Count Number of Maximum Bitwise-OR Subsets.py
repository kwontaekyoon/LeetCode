from ast import List

class Backtracking:
    def countMaxOrSubsets(self, nums: List[int]) -> int:
        max_or = 0

        for num in nums:
            max_or |= num

        self.cnt = 0

        self.backtrack(nums, 0, 0, max_or)
        return self.cnt
    
    def backtrack(self, nums: List[int], idx: int, cur_or: int, max_or: int) -> None:
            if cur_or == max_or:
                self.cnt += 1 << (len(nums) - idx)
                return
            for i in range(idx, len(nums)):
                self.backtrack(nums, i + 1, cur_or | nums[i], max_or)
                
class Counter:
    def countMaxOrSubsets(self, nums: List[int]) -> int:
        max_or = 0
        prev = Counter()
        prev[0] = 1

        for num in nums:
            max_or |= num
            curr = Counter()
            for prev_or, cnt in prev.items():
                curr[prev_or | num] += cnt
            prev.update(curr)
        
        return prev[max_or]