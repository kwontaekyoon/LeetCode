from collections import defaultdict, deque
from typing import List


class Solution:
    def findAllRecipes(self, recipes: List[str], ingredients: List[List[str]], supplies: List[str]) -> List[str]:
        # Store available supplies
        available_supplies = set(supplies)
        # Track which recipes depend on each ingredient
        dependency_graph = defaultdict(list)
        # Count of unavailable ingredients for each recipe
        in_degree = {recipe: 0 for recipe in recipes}

        # Build dependency graph
        for recipe, ing_list in zip(recipes, ingredients):
            for ing in ing_list:
                if ing not in available_supplies:
                    dependency_graph[ing].append(recipe)
                    in_degree[recipe] += 1

        # Queue of recipes that can be made immediately
        queue = deque([recipe for recipe, count in in_degree.items() if not count])
        result = []

        # Process recipes in topological order
        while queue:
            recipe = queue.popleft()
            result.append(recipe)
            
            for dependent in dependency_graph[recipe]:
                in_degree[dependent] -= 1
                if not in_degree[dependent]:
                    queue.append(dependent)

        return result