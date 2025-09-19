class SpreadsheetUsingDict:

    def __init__(self, rows: int):
        self.sheet = {}

    def setCell(self, cell: str, value: int) -> None:
        self.sheet[cell] = value

    def resetCell(self, cell: str) -> None:
        self.sheet[cell] = 0

    def getValue(self, formula: str) -> int:
        A, B = formula[1:].split('+')
        A = int(A) if A.isdigit() else self.sheet.get(A, 0)
        B = int(B) if B.isdigit() else self.sheet.get(B, 0)
        return A + B


class SpreadsheetUsingList:

    def __init__(self, rows: int):
        self.sheet = [[0 for _ in range(26)] for _ in range(rows + 1)]

    def setCell(self, cell: str, value: int) -> None:
        row, col = int(cell[1:]), ord(cell[0]) - ord('A')
        self.sheet[row][col] = value
        
    def resetCell(self, cell: str) -> None:
        row, col = int(cell[1:]), ord(cell[0]) - ord('A')
        self.sheet[row][col] = 0
    
    def getCell(self, cell: str) -> int:
        row, col = int(cell[1:]), ord(cell[0]) - ord('A')
        return self.sheet[row][col]

    def getValue(self, formula: str) -> int:
        A, B = formula[1:].split('+')
        A = int(A) if A.isnumeric() else self.getCell(A)
        B = int(B) if B.isnumeric() else self.getCell(B)
        return A + B


# Your Spreadsheet object will be instantiated and called as such:
# obj = Spreadsheet(rows)
# obj.setCell(cell,value)
# obj.resetCell(cell)
# param_3 = obj.getValue(formula)