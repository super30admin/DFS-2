# Time Complexity : O(m * n), where m is the number of rows and n is the number of columns
# Space Complexity : O(m * n) in the worst case due to recursive stack (DFS)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No

from typing import List
from collections import deque

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:

        rows = len(grid)
        cols = len(grid[0])
        island = 0

        def dfs(r, c):
            if r < 0 or c < 0 or r >= rows or c >= cols or grid[r][c] == "0":
                return
            grid[r][c] = "0"
            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == "1":
                    island += 1
                    dfs(r, c)

        return island

        # ---------------------------------------
        # Alternative: BFS Approach
        # Time Complexity : O(m * n)
        # Space Complexity : O(min(m, n)) in the worst case (queue size at widest level)

        # rows = len(grid)
        # cols = len(grid[0])
        # island = 0
        # directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]

        # for row in range(rows):
        #     for col in range(cols):
        #         if grid[row][col] == "1":
        #             island += 1
        #             q = deque()
        #             q.append((row, col))
        #             grid[row][col] = "0"

        #             while q:
        #                 r, c = q.popleft()
        #                 for dr, dc in directions:
        #                     nr = r + dr
        #                     nc = c + dc
        #                     if 0 <= nr < rows and 0 <= nc < cols and grid[nr][nc] == "1":
        #                         grid[nr][nc] = "0"
        #                         q.append((nr, nc))

        # return island
