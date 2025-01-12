class Solution:
    def canBeValid(self, s: str, locked: str) -> bool:
        n = len(s)
        if n % 2 > 0:
            return False
        opened = []
        unlocked = []
        for i in range(n):
            if locked[i] == '0':
                unlocked.append(i)
            elif s[i] == '(':
                opened.append(i)
            else:
                if opened:
                    opened.pop()
                elif unlocked:
                    unlocked.pop()
                else:
                    return False
        while opened and unlocked and unlocked[-1] > opened[-1]:
            opened.pop()
            unlocked.pop()
        if opened:
            return False
        return True