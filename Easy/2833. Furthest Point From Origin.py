class Solution:
    def furthestDistanceFromOrigin(self, moves: str) -> int:
        curr = 0
        wild = 0
        for move in moves:
            if move == 'L':
                curr -= 1
            elif move == 'R':
                curr += 1
            else:
                wild += 1
        return abs(curr) + wild
