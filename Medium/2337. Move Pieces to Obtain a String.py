class Optimized:
    def canChange(self, start: str, target: str) -> bool:
        waitL, waitR = 0, 0
        for curr, goal in zip(start, target):
            if curr == 'R':
                if waitL > 0:
                    return False
                waitR += 1
            if goal == 'L':
                if waitR > 0:
                    return False
                waitL += 1
            if goal == 'R':
                if waitR == 0:
                    return False
                waitR -= 1
            if curr == 'L':
                if waitL == 0:
                    return False
                waitL -= 1
        return waitL == 0 and waitR == 0
    
class Solution:
    def canChange(self, start: str, target: str) -> bool:
        n = len(start)
        if start.replace("_", "") != target.replace("_", ""):
            return False
        
        startL = [i for i in range(n) if start[i] == "L"]
        endL = [i for i in range(n) if target[i] == "L"]
        startR = [i for i in range(n) if start[i] == "R"]
        endR = [i for i in range(n) if target[i] == "R"]

        for s,e in zip(startL, endL):
            if s < e:
                return False
        
        for s,e in zip(startR, endR):
            if s > e:
                return False
            
        return True
      
            