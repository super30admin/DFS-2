# Time Complexity : O(M*N) where M is the number of rows and N is the number of columns
# Space Complexity : O(M*N) where M is the number of rows and N is the number of columns
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No




class Solution:
    def numIslands(self, grid: [[str]]):

        if not grid or len(grid) == 0:
            return 0
        m = len(grid)
        n = len(grid[0])
        directions = [(1,0),(-1,0),(0,1),(0,-1)]

        def dfs(grid:[[str]], i:int, j:int):

            grid[i][j] = '0'
            for dir_i, dir_j in directions:

                new_i = i + dir_i
                new_j = j + dir_j

                if new_i >= 0 and new_i < m and new_j >= 0 and new_j < n and grid[new_i][new_j] == '1':
                    dfs(grid, new_i, new_j)

            return
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1
                    dfs(grid, i,j)
        return count
