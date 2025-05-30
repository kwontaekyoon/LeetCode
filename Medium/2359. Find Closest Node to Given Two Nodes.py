from typing import List


class Solution:
    def closestMeetingNode(self, edges: List[int], node1: int, node2: int) -> int:
        def dfs(current: int, distance: int, edges: List[int], distances: List[int]) -> None:
            while current != -1 and distances[current] == -1:
                distances[current] = distance
                distance += 1
                current = edges[current]
        dist1, dist2 = [-1] * len(edges), [-1] * len(edges)
        dfs(node1, 0, edges, dist1)
        dfs(node2, 0, edges, dist2)
        result, min_of_max = -1, float('inf')
        for i in range(len(edges)):
            if dist1[i] >= 0 and dist2[i] >= 0:
                max_dist = max(dist1[i], dist2[i])
                if max_dist < min_of_max:
                    min_of_max = max_dist
                    result = i
        return result