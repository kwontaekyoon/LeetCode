import heapq
from typing import List


class Solution:
    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        meetings.sort(key = lambda x: x[0])
        used = [0] * n
        rooms = list(range(n))
        heapq.heapify(rooms)
        busy = []
        for start, end in meetings:
            while busy and busy[0][0] <= start:
                _, room = heapq.heappop(busy)
                heapq.heappush(rooms, room)
            if rooms:
                room = heapq.heappop(rooms)
                used[room] += 1
                heapq.heappush(busy, (end, room))
            else:
                time = end - start
                end_time,room = heapq.heappop(busy)
                heapq.heappush(busy, (end_time + time,room))
                used[room] += 1
        max_room = max_used = 0
        for room, cnt in enumerate(used):
            if cnt > max_used:
                max_room = room
                max_used = cnt
        return max_room

class Optimized:
    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        meetings.sort()
        rooms = [i for i in range(n)]
        # end time, room number
        heap = []
        cnt = [0] * n
        for start, end in meetings:
            while heap and heap[0][0] <= start:
                heapq.heappush(rooms, heapq.heappop(heap)[1])
            end_time = room_no = None
            if rooms:
                room_no, end_time = heapq.heappop(rooms), end
            else:
                end_time, room_no = heapq.heappop(heap)
                end_time += end - start
            heapq.heappush(heap, (end_time, room_no))
            cnt[room_no] += 1
        result = 0
        for i in range(n):
            if cnt[i] > cnt[result]:
                result = i
        return result

class Solution1:
    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        meetings.sort()
        cnt = [0] * n
        # (available time, room number)
        room_queue = [(0, i) for i in range(n)]
        for start, end in meetings:
            available_rooms = []
            while room_queue and room_queue[0][0] <= start:
                available_time, room_no = heapq.heappop(room_queue)
                heapq.heappush(available_rooms, (room_no, available_time))
            if not available_rooms:
                available_from, room_no = heapq.heappop(room_queue)
                heapq.heappush(room_queue, (available_from + end - start, room_no))
                cnt[room_no] += 1
                continue
            room_no, _ = heapq.heappop(available_rooms)
            heapq.heappush(room_queue, (start + end - start, room_no))
            cnt[room_no] += 1
            while available_rooms:
                room_no, available_from = heapq.heappop(available_rooms)
                heapq.heappush(room_queue, (available_from, room_no))
        max_held = -1
        result = -1
        for i, v in enumerate(cnt):
            if v > max_held:
                max_held = v
                result = i
        return result
        
