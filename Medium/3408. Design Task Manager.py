import heapq
from typing import List


class TaskManager:

    def __init__(self, tasks: List[List[int]]):
        self.taskheap = []
        self.task_to_priority = {}
        self.task_to_user = {}
        for user, task, priority in tasks:
            heapq.heappush(self.taskheap, (-priority, -task))
            self.task_to_priority[task] = priority
            self.task_to_user[task] = user

    def add(self, userId: int, taskId: int, priority: int) -> None:
        self.task_to_priority[taskId] = priority
        self.task_to_user[taskId] = userId
        heapq.heappush(self.taskheap, (-priority, -taskId))

    def edit(self, taskId: int, newPriority: int) -> None:
        self.task_to_priority[taskId] = newPriority
        heapq.heappush(self.taskheap, (-newPriority, -taskId))

    def rmv(self, taskId: int) -> None:
        del self.task_to_user[taskId]
        del self.task_to_priority[taskId]

    def execTop(self) -> int:
        while self.taskheap:
            priority, task = -self.taskheap[0][0], -self.taskheap[0][1]
            heapq.heappop(self.taskheap)
            if task in self.task_to_priority and self.task_to_priority[task] == priority:
                del self.task_to_priority[task]
                return self.task_to_user[task]
        return -1


# Your TaskManager object will be instantiated and called as such:
# obj = TaskManager(tasks)
# obj.add(userId,taskId,priority)
# obj.edit(taskId,newPriority)
# obj.rmv(taskId)
# param_4 = obj.execTop()