
"""
200. Number of Islands
Medium
"""
from leetcode_runner import LeetCode, TestCase, Args
from typing import *

PROBLEM = """
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


"""


class Solution:
    """
    Accepted
    Time Complexity: O(m*n) - Even though it looks like we are starting DFS from all the 1s, 
        we are not exploring the same island again and again. We are marking the visited islands as -1 and not exploring them again.
        So if an island is touched, all its ones becomes -1 dynamically and we dont explore them again.
    Space Complexity: O(1) - No extra space is used, only the input grid is used

    Approach [DFS]:
    - Start DFS from all the 1s and mark all the connected 1s as -1
    - Count the number of times DFS is called
    - Return the count

    """

    def numIslands(self, grid: List[List[str]]) -> int:
        dirs = [
            [0, 1],
            [1, 0],
            [-1, 0],
            [0, -1]
        ]
        m = len(grid)
        n = len(grid[0])

        def dfs(i, j):  # DFS Helper function to mark all the connected 1s as -1
            if (i < 0 or j < 0 or
                    i >= m or j >= n or
                    grid[i][j] == "0" or
                    grid[i][j] == "-1"
                    ):  # base case, if out of bounds or 0 or Island already visited -> Dont explore further,
                return
            grid[i][j] = "-1"
            for dir in dirs:
                nr = dir[0] + i
                nc = dir[1] + j
                dfs(nr, nc)
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":  # if 1 is found, start DFS
                    count += 1
                    dfs(i, j)
        return count


LeetCode(PROBLEM, Solution).check()
