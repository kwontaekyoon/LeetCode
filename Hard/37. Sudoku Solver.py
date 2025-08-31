from typing import List


class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        boxs = [set() for _ in range(9)]
        def getBox(r: int, c: int) -> int:
            if r < 3:
                if c < 3:
                    return 0
                elif c < 6:
                    return 1
                else:
                    return 2
            elif r < 6:
                if c < 3:
                    return 3
                elif c < 6:
                    return 4
                else:
                    return 5
            else:
                if c < 3:
                    return 6
                elif c < 6:
                    return 7
                else:
                    return 8
        for r in range(9):
            for c in range(9):
                if board[r][c] == '.':
                    continue
                num = int(board[r][c])
                rows[r].add(num)
                cols[c].add(num)
                boxs[getBox(r, c)].add(num)
        def backtrack(r: int, c: int) -> bool:
            if r == 9:
                return True
            if c == 9:
                return backtrack(r + 1, 0)
            if board[r][c] != '.':
                return backtrack(r, c + 1)
            b = getBox(r, c)
            for num in range(1, 10):
                if (num not in rows[r]) and (num not in cols[c]) and (num not in boxs[b]):
                    board[r][c] = str(num)
                    rows[r].add(num)
                    cols[c].add(num)
                    boxs[b].add(num)
                    if backtrack(r, c + 1):
                        return True
                    board[r][c] = '.'
                    rows[r].remove(num)
                    cols[c].remove(num)
                    boxs[b].remove(num)
            return False
        backtrack(0, 0)