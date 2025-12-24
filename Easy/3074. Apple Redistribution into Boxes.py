class Solution:
    def minimumBoxes(self, apple: List[int], capacity: List[int]) -> int:
        apples = sum(apple)
        capacity.sort()
        result = 0
        while capacity and apples > 0:
            apples -= capacity.pop()
            result += 1
        return result