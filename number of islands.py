#TC: O(m*n)
#SC: O(min(m,n))

from collections import deque
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        dir = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        m = len(grid)
        n = len(grid[0])

        count = 0
        q = deque()

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1
                    q.append((i, j))

                    while len(q) > 0:
                        curr = q.popleft()
                        for d in dir:
                            r = curr[0] + d[0]
                            c = curr[1] + d[1]

                            if r >= 0 and c >= 0 and r < m and c < n and grid[r][c] == '1':
                                grid[r][c] = -1
                                q.append((r, c))

        return count
