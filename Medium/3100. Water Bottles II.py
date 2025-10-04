class Solution:
    def maxBottlesDrunk(self, bottles: int, x: int) -> int:
        drunk = bottles
        while bottles >= x:
            bottles -= x - 1
            x += 1
            drunk += 1
        return drunk
        
    def maxBottlesDrunk1(self, bottles: int, rate: int) -> int:
        empty = drunk = 0
        while bottles:
            empty += bottles
            drunk += bottles
            bottles = 0
            if empty >= rate:
                bottles += 1
                empty -= rate
                rate += 1
        return drunk