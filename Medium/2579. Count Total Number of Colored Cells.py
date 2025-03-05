class Math:
    def coloredCells(self, n: int) -> int:
        # 1 + 4 * 1 + 4 * 2 + 4 * 3 + 4 * 4 ... + 4 * (n - 1)
        # 1 + 4 * (1 + 2 + 3 + ... (n - 1))
        return 1 + 4 * (n - 1) * n // 2

class BruteForce:
    def coloredCells(self, n: int) -> int:
        res = 1
        for i in range(1, n):
            res += i * 4
        return res