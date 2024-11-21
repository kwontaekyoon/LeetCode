from typing import List


class Solution:
    def countUnguarded(self, m: int, n: int, guards: List[List[int]], walls: List[List[int]]) -> int:
        unguarded = m * n
        map = [[0 for _ in range(n)] for _ in range(m)]
        for r, c in guards + walls:
            unguarded -= 1
            map[r][c] = 1
        for cr, cc in guards:
            for dr, dc in [[0, 1], [0, -1], [1, 0], [-1, 0]]:
                nr, nc = cr + dr, cc + dc
                while -1 < nr < m and -1 < nc < n and map[nr][nc] != 1:
                    if map[nr][nc] == 0:
                        unguarded -= 1
                    map[nr][nc] = 2
                    nr += dr
                    nc += dc
        return unguarded

class Solution1:
    def checkRow(self, c: int, f: int, t: int, d: int) -> None:
        for r in range(f, t, d):
            if self.map[r][c] == -2 or self.map[r][c] == 1:
                break
            if self.map[r][c] == 0:
                self.unguarded -= 1
                self.map[r][c] = -1
    def checkCol(self, r: int, f: int, t: int, d: int) -> None:
        for c in range(f, t, d):
            if self.map[r][c] == -2 or self.map[r][c] == 1:
                break
            if self.map[r][c] == 0:
                self.unguarded -= 1
                self.map[r][c] = -1

    def countUnguarded(self, m: int, n: int, guards: List[List[int]], walls: List[List[int]]) -> int:
        self.unguarded = m * n
        self.map = [[0 for c in range(n)] for r in range(m)]
        for r, c in guards:
            self.map[r][c] = 1
        for r, c in walls:
            self.map[r][c] = -2
        for i in range(m):
            for j in range(n):
                if self.map[i][j] == 1:
                    self.unguarded -= 1
                    self.checkRow(j, i - 1, -1, -1)
                    self.checkRow(j, i + 1, m, 1)
                    self.checkCol(i, j - 1, -1, -1)
                    self.checkCol(i, j + 1, n, 1)
                elif self.map[i][j] == -2:
                    self.unguarded -= 1

        return self.unguarded