"""
Leetcode-https://leetcode.com/problems/number-of-islands/ (submitted)
TC- , SC-
Challenges - Coming up with optimal solution - making visited nodes as 0, was counterintuitive initially
Lecture-https://youtu.be/NCnxoc4RDLg
FAQ-


Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume
all four edges of the grid are all surrounded by water.


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
grid[i][j] is '0' or '1'
"""

import collections


class Solution:
    """
    Ideation- DFS O(N) time and O(1) auxiliary space

    Visit all connected components and change their state (inplace) once they are visited, so they are not visited again.
    This will make our TC- O(N) instead of O(N^2).
    Do a for loop and call DFS on all 1's. But since we change the state of visited 1's inplace in DFS, the for loop will
    not pick up the visited 1's again, making TC O(1).

    Change the 
    """

    def numIslands(self, grid):
        m, n = len(grid), len(grid[0])
        count = 0
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    grid[i][j] = 0
                    self.dfs(grid, i, j, dirs, m, n)
                    count += 1

        return count

    def dfs(self, grid, r, c, dirs, m, n):
        for dir in dirs:
            nr, nc = r + dir[0], c + dir[1]
            if 0 <= nr < m and 0 <= nc < n and grid[nr][nc] == "1":
                grid[nr][nc] = 0
                self.dfs(grid, nr, nc, dirs, m, n)

    """
    Ideation- BFS O(N) time and O(N) space
    
    The idea is same as DFS.
    """

    def numIslands1(self, grid):
        m, n = len(grid), len(grid[0])
        count = 0
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        q = collections.deque()
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    q.append([i, j])
                    grid[i][j] = 0
                    while q:
                        x, y = q.popleft()
                        for dir in dirs:
                            nr, nc = x + dir[0], y + dir[1]
                            if 0 <= nr < m and 0 <= nc < n and grid[nr][nc] == "1":
                                grid[nr][nc] = 0
                                q.append([nr, nc])
                    count += 1

        return count


grid = [["1", "1"], ["1", "1"]]
result = Solution().numIslands(grid)
print(result)
