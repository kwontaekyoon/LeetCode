class Solution:
    def getHappyString(self, n: int, k: int) -> str:
        def recursion(curr: str, left: int, k: int) -> str:
            if left == 0:
                return curr
            for c in 'abc':
                if curr and curr[-1] == c:
                    continue
                cnt = 2 ** (n - len(curr) - 1)
                if k > cnt:
                    k -= cnt
                else:
                    return recursion(curr + c, left - 1, k)
            return ''
        return recursion('', n, k)