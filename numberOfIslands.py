from typing import List
from collections import deque

class DFSSolution:
# Time Complexity : O(m*n) where m is the number of rows and n is the number of columns in the image
# Space Complexity : O(m*n) in the worst case when all the pixels have the same color and we need to change all of them
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

    # DFS
    def __init__(self):
        self.m = 0
        self.n = 0
        self.neighbors = [[-1,0],[0,-1],[0,1],[1,0]] # Top, left, right, bottom
        self.result = 0

    def numIslands(self, grid: List[List[str]]) -> int:
        self.m = len(grid)
        self.n = len(grid[0])

        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == "1":
                    self.result += 1
                    self.dfs(grid, i, j)

        return self.result

    def dfs(self,grid: List[List[str]], i: int, j: int )-> None:
        grid[i][j] = "0"
        for neighbor in self.neighbors:
            r = i + neighbor[0]
            c = j + neighbor[1]
            if r >=0 and c >= 0 and r < self.m and c < self.n and grid[r][c] == "1":
                self.dfs(grid, r, c)

class BFSSolution:
# Time Complexity : O(m*n) where m is the number of rows and n is the number of columns in the image
# Space Complexity : O(m*n) in the worst case when all the pixels have the same color and we need to change all of them
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

    # BFS
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        q = deque()
        neighbors = [[-1,0],[0,-1],[0,1],[1,0]] # Top, left, right, bottom
        result = 0

        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    q.append((i,j))
                    grid[i][j] = "0"
                    result += 1

                    while len(q):
                        curr = q.popleft()
                        for neighbor in neighbors:
                            r = curr[0] + neighbor[0]
                            c = curr[1] + neighbor[1]
                            if r >= 0 and c >= 0 and r < m and c < n and grid[r][c] == "1":
                                grid[r][c] = "0"
                                q.append((r,c))
        return result