# Did this code successfully run on Leetcode : YES

# TC: O(M*N)
# SC: O(M*N)

# DFS

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count = 0
        # visited = set()
        m = len(grid)
        n = len(grid[0])
        def dfs(i, j):
            if 0 <= i < m and 0 <= j < n and grid[i][j] == '1':
                grid[i][j] = '0'
                dfs(i+1, j)
                dfs(i-1, j)
                dfs(i, j-1)
                dfs(i, j+1)
            # visited.add((i, j))
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    dfs(i, j)
                    count += 1
        return count

# BFS

from collections import deque
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        result = 0
        q = deque()
        m, n = len(grid), len(grid[0])
        dirs = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        for x in range(m):
            for y in range(n):
                if grid[x][y] == '1':
                    grid[x][y] = '0'
                    # print((i, j))
                    result += 1
                    q.append([x, y])
                    # print(q)
                    while q:
                        [i, j] = q.popleft()
                        if i + 1 < m and grid[i+1][j] == '1':
                            grid[i+1][j] = '0'
                            q.append([i+1, j])
                        if i - 1 >= 0 and grid[i-1][j] == '1':
                            grid[i-1][j] = '0'
                            q.append([i-1, j])
                        if j - 1 >= 0 and grid[i][j-1] == '1':
                            grid[i][j-1] = '0'
                            q.append([i, j-1])
                        if j + 1 < n and grid[i][j+1] == '1':
                            grid[i][j+1] = '0'
                            q.append([i, j+1])
        # print(grid)
        return result