import collections

class Solution:
    def minimumScore(self, nums: list[int], edges: list[list[int]]) -> int:
        """
        Calculates the minimum score after removing two edges from the tree.

        :param nums: List of node values.
        :param edges: List of edges in the tree.
        :return: Minimum score achievable.
        """
        n = len(nums)
        graph = collections.defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)

        subtree_xor = [0] * n
        in_time = [0] * n
        out_time = [0] * n
        time = [0]

        def dfs(node: int, parent: int) -> None:
            """Performs DFS to compute subtree XOR and in/out times."""
            time[0] += 1
            in_time[node] = time[0]
            subtree_xor[node] = nums[node]
            for neighbor in graph[node]:
                if neighbor != parent:
                    dfs(neighbor, node)
                    subtree_xor[node] ^= subtree_xor[neighbor]
            out_time[node] = time[0]

        def is_ancestor(u: int, v: int) -> bool:
            """Checks if node u is an ancestor of node v."""
            return in_time[u] <= in_time[v] and out_time[v] <= out_time[u]

        dfs(0, -1)
        total_xor = subtree_xor[0]
        min_score = float('inf')

        # Try all pairs of nodes (i, j) as cut points (excluding root)
        for i in range(1, n):
            for j in range(i + 1, n):
                xor_i = subtree_xor[i]
                xor_j = subtree_xor[j]

                # Case 1: j is in i's subtree
                if is_ancestor(i, j):
                    part1 = xor_j
                    part2 = xor_i ^ xor_j
                    part3 = total_xor ^ xor_i
                # Case 2: i is in j's subtree
                elif is_ancestor(j, i):
                    part1 = xor_i
                    part2 = xor_j ^ xor_i
                    part3 = total_xor ^ xor_j
                # Case 3: i and j are independent
                else:
                    part1 = xor_i
                    part2 = xor_j
                    part3 = total_xor ^ xor_i ^ xor_j

                score = max(part1, part2, part3) - min(part1, part2, part3)
                min_score = min(min_score, score)

        return min_score # type: ignore