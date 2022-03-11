TC:O(m*n)
SC:O(m*n)

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        self.result = 0
        self.dirs = [[0, 1], [0, -1], [-1, 0], [1, 0]]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    self.result += 1
                    self.dfs(grid, i, j)

        return self.result

    def dfs(self, grid, i, j):
        if grid[i][j] == "0":
            return

        grid[i][j] = "0"
        for _dir in self.dirs:
            nr = i + _dir[0]
            nc = j + _dir[1]

            if 0 <= nr < len(grid) and 0 <= nc < len(grid[0]):
                self.dfs(grid, nr, nc)




