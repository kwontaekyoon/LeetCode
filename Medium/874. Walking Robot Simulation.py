class Solution:
    def robotSim(self, commands, obstacles):
        blocked = set(map(tuple, obstacles))
        directions = ((0, 1), (1, 0), (0, -1), (-1, 0))
        x = y = d = 0
        max_dist = 0

        for cmd in commands:
            if cmd == -1:
                d = (d + 1) % 4  # turn right
            elif cmd == -2:
                d = (d + 3) % 4  # turn left
            else:
                while cmd > 0:
                    nx = x + directions[d][0]
                    ny = y + directions[d][1]

                    # check obstacle
                    if (nx, ny) in blocked:
                        break

                    x = nx
                    y = ny

                    max_dist = max(max_dist, x * x + y * y)
                    cmd -= 1

        return max_dist
