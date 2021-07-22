# Time Complexity: O(mn), where m - num of rows and n - num of cols
# Space Complexity: O(mn)
# Did this code successfully run on Leetcode: Yes

# Solution:

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid or len(grid) == 0:
            return 0

        self.rows = len(grid)
        self.cols = len(grid[0])
        count = 0

        # Start the dfs when '1' is found
        for i in range(self.rows):
            for j in range(self.cols):
                if grid[i][j] == "1":
                    # An entire dfs is counted as 1 island
                    count += 1
                    self.dfs(grid, i, j)

        return count

    def dfs(self, grid: List[List[str]], row: int, col: int) -> None:
        # base - Return when '0' is hit or row and col are out of bounds
        if row < 0 or row == self.rows or col < 0 or col == self.cols or grid[row][col] == "0":
            return

        # logic - As long as value is "1", mark it as visited and recursively traverse in four directions
        grid[row][col] = "0"
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        for d in dirs:
            r = row + d[0]
            c = col + d[1]
            self.dfs(grid, r, c)
