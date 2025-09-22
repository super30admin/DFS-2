"""
TC: O(N*M) {each pixel in the grid is visited at most once}
SC: O(N*M) {in the worst-case scenario, the recursive call stack can be as deep as the total number of pixels in the grid}

Approach:

This problem is solved using a **Depth-First Search (DFS)** approach to count the number of distinct islands. 

An island is defined as a group of connected '1's (land) surrounded by '0's (water).

We iterate through each cell of the grid. If we encounter a cell that contains a '1', it signifies the start of a new island. 
At this point, we increment our island count. We then initiate a DFS from this cell to find and "sink" the entire island. 
The DFS function works by taking the coordinates of a cell and recursively exploring all its adjacent neighbors (up, down, left, right). 
During this traversal, we mark each '1' we visit with a different value (e.g., '2') to ensure we don't count it as part of a new island later in our iteration.

The recursion stops when it encounters a cell that is out of bounds, is not a '1' (it's either water '0' or a cell we've already visited '2'), 
or when all connected '1's have been visited. This process guarantees that we only count each connected component of '1's once. 

After the loops complete, we have an accurate count of all the islands.

The problem ran successfully on LeetCode.
"""
from typing import List
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def inBounds(x, y):
            return 0<=x<n and 0<=y<m

        def dfs(x, y):
            if not inBounds(x, y) or grid[x][y] != "1":
                return

            grid[x][y] = "2"

            dfs(x+1, y)
            dfs(x-1, y)
            dfs(x, y+1)
            dfs(x, y-1)
            
        n,m = len(grid), len(grid[0])
        nei = [[0,1], [1,0], [-1,0], [0,-1]]
        res = 0

        for i in range(n):
            for j in range(m):
                if grid[i][j] == "1":
                    dfs(i,j)
                    res += 1

        return res