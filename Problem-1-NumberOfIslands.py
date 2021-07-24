class Solution:
    def numIslands(self, grid):
        if grid == None or len(grid) == 0:
            return
        m = len(grid)
        n = len(grid[0])
        islandcount = 0

        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    islandcount += 1
                    self.dfs(grid, i, j, m, n)
        return islandcount

    def dfs(self, grid, r, c, m, n):
        if r < 0 or c < 0 or r >= m or c >= n or grid[r][c] == "0":
            return
        grid[r][c] = "0"

        dirs = ((0, -1), (0, 1), (-1, 0), (1, 0))

        for dir in dirs:
            nr = r + dir[0]
            nc = c + dir[1]

            self.dfs(grid, nr, nc, m, n)

#Time complexity:O(mn)
#Space complexity:O(mn)