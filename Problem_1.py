# class Solution:
#     def numIslands(self, grid):
#         rows, cols = len(grid), len(grid[0])
#         neighbours = [[1, 0], [-1, 0], [0, 1], [0, -1]]
#         count = 0
#         for r in range(rows):
#             for c in range(cols):
#                 if grid[r][c] == "1":
#                     self.dfs(r, c, grid, neighbours)
#                     count += 1
#         return count

#     def dfs(self, r, c, grid, neighbours):
#         grid[r][c] = "0"
#         for x, y in neighbours:
#             nr, nc = r + x, c + y
#             if 0 <= nr < len(grid) and 0 <= nc < len(grid[0]) and grid[nr][nc] == "1":
#                 self.dfs(nr, nc, grid, neighbours)

from collections import deque


class Solution:
    def numIslands(self, grid):
        rows, cols = len(grid), len(grid[0])
        neighbours = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        count = 0
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == "1":
                    self.bfs(r, c, grid, neighbours)
                    count += 1
        return count

    def bfs(self, r, c, grid, neighbours):
        rows, cols = len(grid), len(grid[0])
        q = deque()
        q.append((r, c))
        grid[r][c] = "0"
        while q:
            cr, cc = q.popleft()
            for x, y in neighbours:
                nr, nc = cr + x, cc + y
                if 0 <= nr < rows and 0 <= nc < cols and grid[nr][nc] == "1":
                    q.append((nr, nc))
                    grid[nr][nc] = "0"

