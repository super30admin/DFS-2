# Time Complexity : O(m*n), where m is the number of rows and n is the number of columns
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])

        count = 0

        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        def dfs(row, col):
            if row < 0 or row >= m or col < 0 or col >= n or grid[row][col] != "1":
                return

            grid[row][col] = -1

            for d in dirs:
                r = row + d[0]
                c = col + d[1]

                dfs(r, c)

        for i in range(m):
            for j in range(n):

                if grid[i][j] == "1":
                    count += 1
                    dfs(i, j)

        return count