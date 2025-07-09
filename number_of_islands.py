# Time Complexity : O(m * n), where m and n are the dimensions of the grid
# Space Complexity : O(m * n), for the recursion stack in the worst case
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# I used DFS to visit all connected '1's starting from any unvisited land cell.
# Every time I found a '1', I treated it as a new island and launched a DFS to mark the entire island as visited.
# I modified the input grid in place by setting visited land cells to '0'.

from typing import List

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid or not grid[0]:
            return 0

        rows, cols = len(grid), len(grid[0])
        count = 0

        def dfs(r, c):
            if r < 0 or r >= rows or c < 0 or c >= cols or grid[r][c] == '0':
                return
            grid[r][c] = '0'  # Mark as visited
            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == '1':
                    count += 1
                    dfs(r, c)

        return count
