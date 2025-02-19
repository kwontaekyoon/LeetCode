class Stack:
    def smallestNumber(self, pattern: str) -> str:
        n = len(pattern)
        res = ''
        stack = []
        for i in range(n + 1):
            stack.append(i + 1)
            if i == n or pattern[i] == 'I':
                while stack:
                    res += str(stack.pop())
        return res

class Backtracking:
    def smallestNumber(self, pattern: str) -> str:
        def backtrack(i: int) -> bool:
            if i == n + 1:
                return True
            for num in range(1, res[-1] if i else n + 2) if pattern[i - 1] == 'D' or i == 0 else range(res[-1], n + 2):
                if num in used:
                    continue
                used.add(num)
                res.append(num)
                if backtrack(i + 1):
                    return True
                used.remove(num)
                res.pop()
            return False
        n = len(pattern)
        used = set()
        res = []
        backtrack(0)
        return ''.join(map(str, res))