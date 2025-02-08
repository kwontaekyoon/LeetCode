import heapq


class NumberContainers:
    
    def __init__(self):
        self.number_to_index = {}
        self.index_to_number = {}

    def change(self, index: int, number: int) -> None:
        if number not in self.number_to_index:
            self.number_to_index[number] = [index]
        else:
            heapq.heappush(self.number_to_index[number], index)
        self.index_to_number[index] = number

    def find(self, number: int) -> int:
        if number not in self.number_to_index:
            return -1
        while self.number_to_index[number] and self.index_to_number[self.number_to_index[number][0]] != number:
            heapq.heappop(self.number_to_index[number])
        return self.number_to_index[number][0] if self.number_to_index[number] else -1


# Your NumberContainers object will be instantiated and called as such:
# obj = NumberContainers()
# obj.change(index,number)
# param_2 = obj.find(number)