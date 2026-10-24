prefixSum = [0]
for date in [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]:
    prefixSum.append(prefixSum[-1] + date)
class Solution:
    def countDaysTogether(
        self, arriveAlice: str, leaveAlice: str, arriveBob: str, leaveBob: str
    ) -> int:
        def f(day: str) -> int:
            month = int(day[:2])
            date = int(day[3:])
            return prefixSum[month - 1] + date
        arriveAliceDay = f(arriveAlice)
        leaveAliceDay = f(leaveAlice)
        arriveBobDay = f(arriveBob)
        leaveBobDay = f(leaveBob)
        return max(0, min(leaveAliceDay, leaveBobDay) - max(arriveAliceDay, arriveBobDay) + 1)