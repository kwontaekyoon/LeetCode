from collections import defaultdict
import heapq
from typing import List


class FoodRatings:
    def __init__(self, foods: List[str], cuisines: List[str], ratings: List[int]):
        self.food_to_cuisine = {}
        self.food_to_rating = {}
        self.cuisine_to_highest = defaultdict(list)
        for food, cuisine, rating in zip(foods, cuisines, ratings):
            self.food_to_cuisine[food] = cuisine
            self.food_to_rating[food] = rating
            heapq.heappush(self.cuisine_to_highest[cuisine], (-rating, food))

    def changeRating(self, food: str, newRating: int) -> None:
        self.food_to_rating[food] = newRating
        heapq.heappush(self.cuisine_to_highest[self.food_to_cuisine[food]], (-newRating, food))

    def highestRated(self, cuisine: str) -> str:
        heap = self.cuisine_to_highest[cuisine] 
        while heap:
            highest, food = heap[0]
            if -highest == self.food_to_rating[food]:
                return food
            heapq.heappop(heap)
        return ""


# Your FoodRatings object will be instantiated and called as such:
# obj = FoodRatings(foods, cuisines, ratings)
# obj.changeRating(food,newRating)
# param_2 = obj.highestRated(cuisine)