from collections import defaultdict


class HashTable:
    def countLargestGroup(self, n: int) -> int:
        dp = [0]
        groups = [0] * (9 * 4 + 1)
        for v in range(1, n + 1):
            q, r = divmod(v, 10)
            dp.append(r + dp[q])
            groups[dp[-1]] += 1
        return groups.count(max(groups))

class BF:
    def countLargestGroup(self, n: int) -> int:
        def helper(num: int) -> int:
            group_id = 0
            while num > 0:
                group_id += num % 10
                num //= 10
            return group_id
        count = defaultdict(int)
        result = 0
        max_len = 0
        for v in range(1, n + 1):
            curr_id = helper(v)
            count[curr_id] += 1
            if count[curr_id] == max_len:
                result += 1
            elif count[curr_id] > max_len:
                max_len = count[curr_id]
                result = 1
        return result