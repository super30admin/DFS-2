# Time Complexity : O(m*n)
# Space Complexity : O(min(m,n))
from collections import deque

class Solution:
    def numIslands(self, grid: list[list[str]]) -> int:
        if not grid or not grid[0]:
            return 0

        m, n = len(grid), len(grid[0])
        count = 0
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]  # U, D, L, R
        q = deque()

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    grid[i][j] = '0'
                    count += 1
                    q.append((i, j))
                    while q:
                        cur = q.popleft()
                        for dir in dirs:
                            nr, nc = cur[0] + dir[0], cur[1] + dir[1]
                            if 0 <= nr < m and 0 <= nc < n and grid[nr][nc] == '1':
                                q.append((nr, nc))
                                grid[nr][nc] = '0'
        return count

# Example usage:
sol = Solution()

# Example 1
grid1 = [
    ["1","1","1","1","0"],
    ["1","1","0","1","0"],
    ["1","1","0","0","0"],
    ["0","0","0","0","0"]
]
print(sol.numIslands(grid1)) # 1

# Example 2
grid2 = [
    ["1","1","0","0","0"],
    ["1","1","0","0","0"],
    ["0","0","1","0","0"],
    ["0","0","0","1","1"]
]
print(sol.numIslands(grid2)) # 3

# Example 3
grid3 = [
    ["1","0","1","0","1"],
    ["0","1","0","1","0"],
    ["1","0","1","0","1"]
]
print(sol.numIslands(grid3)) # 8