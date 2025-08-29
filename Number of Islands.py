# Time Complexity : O(m * n)
# Space Complexity : O(m * n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# ExplaianationThis code counts the number of islands in a binary grid using DFS. It iterates through the grid, and whenever a '1' (land) is found, it increments the island count and calls DFS to mark all connected land as '0' (water). The DFS explores in all four directions, ensuring that each island is fully traversed and not counted multiple times.


# Your code here along with comments explaining your approach

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        #dfs
        #TC: O(m * n)    SC: O(m * n)
        self.dirs = [[-1, 0], [1, 0], [0, 1], [0, -1]]
        self.m = len(grid)
        self.n = len(grid[0])
        count = 0

        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == '1':
                    count += 1
                    self.dfs(grid, i, j)

        return count

    def dfs(self, grid, i, j):
        if i < 0 or j < 0 or i == self.m or j == self.n or grid[i][j] != '1':
            return

        grid[i][j] = '0'
        for dir in self.dirs:
            r = dir[0] + i
            c = dir[1] + j
            self.dfs(grid, r, c)
