class Solution:
    def bestClosingTime(self, customers: str) -> int:
        y, n = customers.count('Y'), 0
        min_penalty = y
        best_closing_time = -1
        for i, v in enumerate(customers):
            if v == 'Y':
                y -= 1
            else:
                n += 1
            curr_penalty = n + y
            if curr_penalty < min_penalty:
                min_penalty = curr_penalty
                best_closing_time = i
        return best_closing_time + 1