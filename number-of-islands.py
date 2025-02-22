# Time Complexity : O(m*n) - m is number of rows and n is number of columns of grid
# Space Complexity : O(min(m,n)) -  m is number of rows and n is number of columns of grid
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
Do BFS whenever we find a "1" while iterating through the grid
"""
from collections import deque


class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """

        if not grid:
            return 0

        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        m = len(grid)
        n = len(grid[0])
        count = 0

        for i in range(0, m):
            for j in range(0, n):
                if grid[i][j] == "1":
                    count += 1
                    queue = deque()
                    queue.append([i, j])
                    grid[i][j] = "0"
                    while queue:
                        curr = queue.popleft()
                        r = curr[0]
                        c = curr[1]
                        for dir in dirs:
                            nr = dir[0] + r
                            nc = dir[1] + c
                            if 0 <= nr < m and 0 <= nc < n and grid[nr][nc] == "1":
                                queue.append([nr, nc])
                                grid[nr][nc] = "0"

        return count