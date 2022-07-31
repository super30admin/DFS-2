'''

## Problem 200: Number of islands

## Author: Neha Doiphode
## Date:   07-30-2022

## Description:
    Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
    return the number of islands.

    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    You may assume all four edges of the grid are all surrounded by water.

## Examples:
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

## Constraints:
    m == grid.length
    n == grid[i].length
    1 <= m, n <= 300
    grid[i][j] is '0' or '1'.


## Time complexity: Please refer to doc-strings of respective approaches used below to solve the problem.

## Space complexity: Please refer to doc-strings of respective approaches used below to solve the problem.

'''

from typing import List, Optional
from queue import Queue
from copy import deepcopy

def get_input():
    print("Enter the number of rows on the grid: ", end = "")
    rows = int(input())
    print("Enter the number of columns on the grid: ", end = "")
    columns = int(input())
    grid = []
    for row in range(rows):
        l = []
        print(f"Row {row + 1}: ")
        for column in range(columns):
            inp = input()
            l.append(inp)
        grid.append(l)

    return grid

class Solution:
    m = 0
    n = 0
    dirs = []
    number_of_islands = 0

    def dfs(self, grid, row, col):
        # base
        if row < 0 or col < 0 or row == self.m or col == self.n or grid[row][col] == "0":
            return

        if grid[row][col] == "1":
            grid[row][col] = "0"

        # logic
        for direct in self.dirs:
            nr = row + direct[0]
            nc = col + direct[1]
            self.dfs(grid, nr, nc)

    def numIslands_DFS(self, grid: List[List[str]]) -> int:
        """
        Time complexity: O(m * n) where m is the number of rows and n is the number of columns.

        Space complexity: O(m * n), in worst case grid is filled with all lands where DFS goes by m * n deep(recursive stack).
        """
        if all(grid[row][col] == "0" for row in range(len(grid)) for col in range(len(grid[0]))):
            return 0

        self.m = len(grid)
        self.n = len(grid[0])
        self.dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        number_of_islands = 0

        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col] == "1":
                    self.dfs(grid, row, col)
                    number_of_islands += 1

        return number_of_islands

    def numIslands_BFS(self, grid: List[List[str]]) -> int:
        '''
        Time complexity: O(m * n) where m is the number of rows and n is the number of columns.

        Space complexity: O(min (m, n)), because in worst case where the grid is filled with lands,
                                         the size of queue can grow up to min(m, n).
        '''
        if all(grid[row][col] == "0" for row in range(len(grid)) for col in range(len(grid[0]))):
            return 0

        q = Queue()
        self.number_of_islands = 0
        self.m = len(grid)
        self.n = len(grid[0])
        self.dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]

        for row in range(len(grid)):
            for col in range(len(grid[0])):
                if grid[row][col] == "1":
                    q.put([row, col])
                    self.number_of_islands += 1
                    while not q.empty():
                        cell = q.get()
                        for direct in self.dirs:
                            nr = cell[0] + direct[0]
                            nc = cell[1] + direct[1]
                            if nr >= 0 and nr < self.m and nc >= 0 and nc < self.n and grid[nr][nc] != "0":
                                grid[nr][nc] = "0"
                                q.put([nr, nc])

        return self.number_of_islands

# Driver code
solution = Solution()
grid = get_input()
grid1 = deepcopy(grid)
print(f"Input grid: {grid}")
print(f"Approach 1: Using DFS: Number of islands: {solution.numIslands_DFS(grid)}")
print(f"Approach 2: Using BFS: Number of islands: {solution.numIslands_BFS(grid1)}")
