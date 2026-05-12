class Solution:
    def minimumEffort(self, tasks: List[List[int]]) -> int:
        tasks.sort(key=lambda x : -(x[1] - x[0]))
        curr_energy = 0
        total_energy = 0
        for actual, minimum in tasks:
            if minimum > curr_energy:
                total_energy += minimum - curr_energy
                curr_energy = minimum - actual
            else:
                curr_energy -= actual
        return total_energy
