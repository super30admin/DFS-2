from collections import deque


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid is None or len(grid) == 0:
            return 0
        m = len(grid)
        n = len(grid[0])
        count = 0
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        q = deque()

        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    count += 1
                    grid[i][j] = 0
                    q.append([i, j])

                    while q:
                        curr = q.popleft()
                        for d in dirs:
                            cr = curr[0] + d[0]
                            cc = curr[1] + d[1]

                            if cr >= 0 and cc >= 0 and cr < m and cc < n and grid[cr][cc] == "1":
                                grid[cr][cc] = 0
                                q.append([cr, cc])

        return count

# BFS
# Time complexity : O(m * n)
# Space complexity : O(m * n). At max in worst case queue can have all the elements of the matrix.
# Did this code successfully run on Leetcode? Yes
# Any problem you faced while coding this? No