class BFS:
    def canReach(self, arr: List[int], start: int) -> bool:
        n = len(arr)
        visited = [False] * n
        queue = deque([start])
        visited[start] = True
        while queue:
            curr = queue.popleft()
            if arr[curr] == 0:
                return True
            left = curr - arr[curr]
            if 0 <= left and not visited[left]:
                queue.append(left)
                visited[left] = True
            right = curr + arr[curr]
            if right < n and not visited[right]:
                queue.append(right)
                visited[right] = True
        return False

class DFS:
    def canReach(self, arr: List[int], start: int) -> bool:
        n = len(arr)
        visited = [False] * n
        stack = [start]
        visited[start] = True
        while stack:
            curr = stack.pop()
            if arr[curr] == 0:
                return True
            left = curr - arr[curr]
            if 0 <= left and not visited[left]:
                stack.append(left)
                visited[left] = True
            right = curr + arr[curr]
            if right < n and not visited[right]:
                stack.append(right)
                visited[right] = True
        return False
