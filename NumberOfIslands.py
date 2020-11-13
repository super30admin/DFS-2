#Time Complexity : O(mn) where m is is number of columns and n is number of rows
#Space Complexity :  O(mn) where m is is number of columns and n is number of rows

#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: Iterate through the grid, if we come across a 1 call DFS on it and find all the 1's connected to it that form an island by visiting all four directions recursively, while visiting these neighbors change them to 0 so we know we have visited them. And if we either reach out of bounds or encounter a 0. 

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        dirs = [(0,1), (1,0), (-1,0), (0,-1)]
        rows, cols = len(grid), len(grid[0])
        def dfs(grid, r, c):
            if r < 0 or r >= rows or c < 0 or c >= cols or grid[r][c] == "0":
                return
            grid[r][c] = "0"
            for x, y in dirs:
                dfs(grid, r+x, c+y)

        if grid is None or len(grid) == 0:
            return 0

        islands = 0
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == "1":
                    dfs(grid, r, c)
                    islands += 1

        return islands
