# // Time Complexity : O(N)
# // Space Complexity : O(N)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        r = len(grid)
        c = len(grid[0])
        count = 0
        for i in range(r):
            for j in range(c):
                if grid[i][j] == "1":
                    self.dfs(grid, i, j, r, c, directions)
                    count += 1
        return count

    def dfs(self, grid, i, j, r, c, directions):
        if 0 > i or i == r or j == c or j < 0 or grid[i][j] != "1":
            return
        grid[i][j] = "0"

        for x, y in directions:
            nx = x + i
            ny = y + j
            self.dfs(grid, nx, ny, r, c, directions)
        return