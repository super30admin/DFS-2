
from collections import deque

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def bfs(r, c):
            if r < 0 or r >= row or c < 0 or c >= col or visited[r][c] or grid[r][c] == "0":
                return 0
            visited[r][c] = True
            directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                bfs(nr, nc)
            return 1

        if not grid or not grid[0]:
            return 0

        row, col = len(grid), len(grid[0])
        visited = [[False] * col for _ in range(row)]
        count = 0

        for i in range(row):
            for j in range(col):
                if not visited[i][j] and grid[i][j] == "1":
                    count += bfs(i, j)

        return count
