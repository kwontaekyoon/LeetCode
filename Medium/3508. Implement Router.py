import bisect
from collections import defaultdict, deque
from typing import List


class Router:

    def __init__(self, memoryLimit: int):
        self.size = memoryLimit
        self.packets = {}
        self.counts = defaultdict(list)
        self.queue = deque()

    def addPacket(self, source: int, destination: int, timestamp: int) -> bool:
        key = (source, destination, timestamp)
        if key in self.packets:
            return False
        if len(self.packets) >= self.size:
            self.forwardPacket()
        self.packets[key] = [source, destination, timestamp]
        self.queue.append(key)
        self.counts[destination].append(timestamp)
        return True

    def forwardPacket(self) -> List[int]:
        if not self.packets:
            return []
        key = self.queue.popleft()
        packet = self.packets.pop(key)
        dest = packet[1]
        self.counts[dest].pop(0)
        return packet

    def getCount(self, destination: int, startTime: int, endTime: int) -> int:
        timestamps = self.counts.get(destination, [])
        if not timestamps:
            return 0
        return bisect.bisect_right(timestamps, endTime) - bisect.bisect_left(timestamps, startTime)


# Your Router object will be instantiated and called as such:
# obj = Router(memoryLimit)
# param_1 = obj.addPacket(source,destination,timestamp)
# param_2 = obj.forwardPacket()
# param_3 = obj.getCount(destination,startTime,endTime)