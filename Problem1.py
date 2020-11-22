# Time Complexity : O(rows*cols)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No



class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid) == 0 or len(grid[0]) == 0:
            return 0
        rows = len(grid)
        cols = len(grid[0])
        count = 0

        def dfs(r, c):
            if r < 0 or r > rows - 1 or c < 0 or c > cols - 1 or grid[r][c] == "0":
                return
            grid[r][c] = "0"
            dfs(r - 1, c)
            dfs(r + 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == "1":
                    dfs(r, c)
                    count += 1
        return count

# Here I started from index 0,0 and went on iterating till i found 1. WHen I found 1 i called the dfs function, made the
# value at that node to be 0 and called the dfs function for its four neighbours. When 1 island will be detected the value
# of count will be increamented and the next index will be searched for to find 1. when again 1 is found, the dfs function is called