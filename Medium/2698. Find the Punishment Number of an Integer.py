class DFS:
    def punishmentNumber(self, n: int) -> int:
        def isValid(num: int, target: int) -> bool:
            if target < 0 or num < target:
                return False
            if num == target:
                return True
            return isValid(num // 10, target - num % 10) or isValid(num // 100, target - num % 100) or isValid(num // 1000, target - num % 1000)
        
        res = 0
        for curr_num in range(1, n + 1):
            sq_num = curr_num * curr_num
            if isValid(sq_num, curr_num):
                res += sq_num
        return res

class Solution1:
    def punishmentNumber(self, n: int) -> int:
        def valid(curr_sum: int, curr_num: str) -> bool:
            if (not curr_num or int(curr_num) == 0) and curr_sum == origin_num:
                return True
            if curr_sum + int(curr_num) < origin_num:
                return False
            for i in range(1, len(curr_num) + 1):
                if valid(curr_sum + int(curr_num[:i]), curr_num[i:]):
                    return True
            return False
        res = 0
        for origin_num in range(1, n + 1):
            target_num = origin_num * origin_num
            if valid(0, str(target_num)):
                res += target_num
        return res