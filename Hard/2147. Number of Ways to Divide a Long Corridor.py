MOD = 1000000007
class Solution:
    def numberOfWays(self, corridor: str) -> int:
        seats = [i for i, v in enumerate(corridor) if v == 'S']
        if not seats or len(seats) % 2:
            return 0
        ways = 1
        for i in range(2, len(seats), 2):
            plants = seats[i] - seats[i - 1]
            ways *= plants
            ways %= MOD
        return ways

class Solution1:
    def numberOfWays(self, corridor: str) -> int:
        s = p = 0
        ways = 1
        for c in corridor:
            if c == 'S':
                if s and s % 2 == 0:
                    ways *= p + 1
                    p = 0
                s += 1
            else:
                if s and s % 2 == 0:
                    p += 1
        return ways % 1000000007 if s and s % 2 == 0 else 0