"""

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 
Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 
Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.

Time Complexity: O(m×n) Each cell is visited once and DFS traverses all connected land cells, marking them as visited.
Space Complexity: O(m×n) (in worst case, for recursive call stack in DFS when all cells are land).

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Approach:
# used Depth-First Search (DFS) to traverse and mark all connected '1's (land) as '0' (visited) whenever we find an unvisited land cell. 
# Each DFS call ensures that all adjacent land cells in four possible directions are explored recursively. 
# By iterating over the grid and invoking DFS for each unvisited land cell, count the number of islands.


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:

        if not grid:
            return 0

        rows, cols = len(grid), len(grid[0])
        count = 0

        def dfs(i, j):
            # base
            if i < 0 or j < 0 or i >= rows or j >= cols or grid[i][j] != "1":
                return

            # logic
            grid[i][j] = "0"
            direct = [(-1, 0), (0, -1), (1, 0), (0, 1)]
            for dr, dc in direct:
                dfs(i+dr, j+dc)

        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == "1":
                    count += 1
                    dfs(i, j)

        return count
