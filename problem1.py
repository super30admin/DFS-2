# Time Complexity : O(M x N) where M is number of rows and N is number of cols
# Space Complexity : O(M x N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, one issue with recursion where I ran into
# infinite recursion, fixed it by moving it to if condition


# Your code here along with comments explaining your approach
# Approach : Basic approach is to find if a grid value if "1", if yes, we make a call to a recursive
# function whose responsibility is to traverse the whole island and mark it as "-1". # Which acts as
# visited/ traversed position. Then we will increase out island_count by 1.
# finally we will return the total count.


from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        max_rows = len(grid)
        max_cols = len(grid[0])
        island_count = 0
        for row in range(max_rows):
            for col in range(max_cols):
                if grid[row][col] == "1":
                    self.dfs(grid, row, col)
                    island_count += 1
        return island_count

    def dfs(self, grid, row, col):
        if row < 0 or col < 0 or row == len(grid) or col == len(grid[0]):
            return
        if grid[row][col] == "0":
            return
        if grid[row][col] == "1":
            grid[row][col] = "-1"
            self.dfs(grid, row + 1, col)
            self.dfs(grid, row, col + 1)
            self.dfs(grid, row, col - 1)
            self.dfs(grid, row - 1, col)
