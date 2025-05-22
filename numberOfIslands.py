from typing import List
from collections import deque


# BFS Approach
# Time: O(M * N), Space: O(min(M, N))
class Solution:
    def numIslandsBFS(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0

        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        m = len(grid)
        n = len(grid[0])
        island = 0

        queue = deque()

        # go through grid and convert 1->0 and count 1s
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    island += 1
                    grid[i][j] = "0"

                    queue.append((i, j))
                    while queue:
                        curr = queue.popleft()
                        for dirc in directions:
                            r = dirc[0] + curr[0]
                            c = dirc[1] + curr[1]
                            if (
                                r >= 0
                                and c >= 0
                                and r < m
                                and c < n
                                and grid[r][c] == "1"
                            ):
                                queue.append((r, c))
                                grid[r][c] = "0"
        return island

    # DFS Approach
    # Time: O(M * N), Space: O(M * N) due to recursion
    def numIslandsDFS(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0

        m, n = len(grid), len(grid[0])
        count = 0

        def dfs(r, c):
            if r < 0 or c < 0 or r >= m or c >= n or grid[r][c] == "0":
                return
            grid[r][c] = "0"
            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)

        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    count += 1
                    dfs(i, j)
        return count


sol = Solution()

grid1 = [
    ["1", "1", "0", "0", "0"],
    ["1", "1", "0", "0", "0"],
    ["0", "0", "1", "0", "0"],
    ["0", "0", "0", "1", "1"],
]

grid2 = [
    ["1", "1", "0", "0", "0"],
    ["1", "1", "0", "0", "0"],
    ["0", "0", "1", "0", "0"],
    ["0", "0", "0", "1", "1"],
]

print("Islands (BFS):", sol.numIslandsBFS(grid1))
print("Islands (DFS):", sol.numIslandsDFS(grid2))
