class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid is None or len(grid) == 0:
            return 0
        self.m = len(grid)
        self.n = len(grid[0])
        count = 0
        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == "1":
                    count += 1
                    self.dfs(grid, i, j)
        return count

    def dfs(self, grid: List[List[str]], row: int, col: int):
        if (
            row < 0
            or col < 0
            or row == self.m
            or col == self.n
            or grid[row][col] != "1"
        ):
            return
        grid[row][col] = "0"
        dirs = [(0, 1), (0, -1), (-1, 0), (1, 0)]
        for dirc in dirs:
            r = row + dirc[0]
            c = col + dirc[1]
            self.dfs(grid, r, c)
