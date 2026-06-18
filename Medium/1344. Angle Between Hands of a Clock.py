class Solution:
    def angleClock(self, hour: int, minutes: int) -> float:
        min_angle = 360 * minutes / 60
        hour_angle = hour * 30 % 360 + 30 * (min_angle / 360)
        if min_angle > hour_angle:
            return min(min_angle - hour_angle, 360 - min_angle + hour_angle)
        else:
            return min(hour_angle - min_angle, 360 - hour_angle + min_angle)
