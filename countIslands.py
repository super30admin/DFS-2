class Solution:
    """
    TC: O(r*c(iterating through the matrix) + r*c(for DFS))
    SC: O(r*c)
    where r -> no. of rows and c -> no. of columns of the grid
    """

    def dfs(self, grid, i, j):

        grid[i][j] = '0'
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        # 4. check all the 4 dirs for 1's
        for dir in dirs:
            m = dir[0] + i
            n = dir[1] + j

            if m >= 0 and m < len(grid) and n >= 0 and n < len(grid[0]) and grid[m][n] == '1':
                self.dfs(grid, m, n)

    def numIslands(self, grid: List[List[str]]) -> int:

        # 1. Base Case
        # check if the grid is Empty or not
        if grid == None or len(grid) == 0:
            return 0

        r, c, count = len(grid), len(grid[0]), 0

        # 1. Check for 1's in the grid
        # iterate the grid
        for i in range(r):
            for j in range(c):

                # 3. apply DFS if you find a 1
                if grid[i][j] == '1':
                    self.dfs(grid, i, j)
                    count += 1

        return count
