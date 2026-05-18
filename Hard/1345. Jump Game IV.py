class Solution:
    def minJumps(self, arr: List[int]) -> int:
        n = len(arr)
        val_to_idxs = defaultdict(list)
        for i, v in enumerate(arr):
            val_to_idxs[v].append(i)
        visited = [False] * n
        queue = deque([(0, 0)])
        visited[0] = True
        while queue:
            jumps, idx = queue.popleft()
            if idx == n - 1:
                return jumps
            jumps += 1
            left, right = idx - 1, idx + 1
            if left >= 0 and not visited[left]:
                queue.append((jumps, left))
                visited[left] = True
            if right < n and not visited[right]:
                queue.append((jumps, right))
                visited[right] = True
            for jump in val_to_idxs[arr[idx]]:
                if not visited[jump]:
                    queue.append((jumps, jump))
                    visited[jump] = True
            val_to_idxs[arr[idx]].clear()
        return -1
