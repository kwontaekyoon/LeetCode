from typing import List


class SolutionWithSet:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [set() for _ in range(9)]        
        cols = [set() for _ in range(9)]        
        boxs = [[set() for _ in range(3)] for _ in range(3)]
        for r, row in enumerate(board):
            for c, v in enumerate(row):
                if v == '.':
                    continue
                num = int(v) - 1
                br, bc = r // 3, c // 3
                if num in rows[r] or num in cols[c] or num in boxs[br][bc]:
                    return False
                rows[r].add(num)
                cols[c].add(num)
                boxs[br][bc].add(num)
        return True

class SolutionWithList:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [[False for _ in range(9)] for _ in range(9)]        
        cols = [[False for _ in range(9)] for _ in range(9)]        
        boxs = [[[False for _ in range(9)] for _ in range(3)] for _ in range(3)]
        for r, row in enumerate(board):
            for c, v in enumerate(row):
                if v == '.':
                    continue
                num = int(v) - 1
                br, bc = r // 3, c // 3
                if rows[r][num] or cols[c][num] or boxs[br][bc][num]:
                    return False
                rows[r][num] = True
                cols[c][num] = True
                boxs[br][bc][num] = True
        return True

class SolutionForIfSudokuSolvable:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
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
                    rows[r].add(num)
                    cols[c].add(num)
                    boxs[b].add(num)
                    if backtrack(r, c + 1):
                        return True
                    rows[r].remove(num)
                    cols[c].remove(num)
                    boxs[b].remove(num)
            return False
        return backtrack(0, 0)