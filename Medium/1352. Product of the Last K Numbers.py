class ProductOfNumbers:

    def __init__(self):
        self.prefix = [1]

    def add(self, num: int) -> None:
        if num:
            self.prefix.append(self.prefix[-1] * num)
        else:
            self.prefix = [1]

    def getProduct(self, k: int) -> int:
        return 0 if k >= len(self.prefix) else self.prefix[-1] // self.prefix[-1 - k]

class ProductOfNumbers1:

    def __init__(self):
        self.prefix = [1]
        self.last_zero = -1

    def add(self, num: int) -> None:
        if num:
            self.prefix.append(self.prefix[-1] * num)
        else:
            self.last_zero = len(self.prefix)
            self.prefix.append(1)

    def getProduct(self, k: int) -> int:
        if self.last_zero >= len(self.prefix) - k:
            return 0
        else:
            return self.prefix[-1] // self.prefix[-k - 1]


# Your ProductOfNumbers object will be instantiated and called as such:
# obj = ProductOfNumbers()
# obj.add(num)
# param_2 = obj.getProduct(k)