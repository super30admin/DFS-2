#Using DFS
# Time and Space complexity : O(mxn)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        rows = len(grid)
        columns = len(grid[0])
        self.dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        self.count = 0
        self.row = 0
        self.column = 0
        for self.row in range(rows):
            for self.column in range(columns):
                if grid[self.row][self.column] == '1':
                    self.count += 1
                    self.dfs(grid, self.row, self.column)
        return self.count

    def dfs(self, grid: List[List[str]], row: int, column: int):
        # base
        if (row < 0 or column < 0 or row == len(grid) or column == len(grid[0]) or grid[row][column] == '0'):
            return
        # logic
        grid[row][column] = '0'  # Make it zero so that dfs won't go there again and again
        for dir in self.dirs:
            r = row + dir[0]
            c = column + dir[1]
            self.dfs(grid, r, c)
