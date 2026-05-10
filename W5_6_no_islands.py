class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        self.count = 0
        self.dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        self.m = len(grid)
        self.n = len(grid[0])

        # Null case
        if not grid:
            return 0
        
        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == "1":
                    self.count = self.count + 1
                    self.dfs(grid, i, j, self.m, self.n)
        
        return self.count
        
    def dfs(self, grid, r, c, m, n):

        # Base
        if r < 0 or c <0 or r == m or c == n or grid[r][c] != "1" :
            return

        # Logic
        grid[r][c] = "0"
        
        for dir in self.dirs:
            nr = r + dir[0]
            nc = c + dir[1]
            self.dfs(grid, nr, nc, m, n)

# Time complexity: O(m *n). We scan each cell once, and DFS visits each land cell at most once across all connected components. 
# Space complexity: O(m * n)