# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
#Approach 1: BFS
from typing import List, deque
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid == None or len(grid) == 0:
            return 0
        m = len(grid)
        n = len(grid[0])
        count = 0
        dirs = [[0,1], [1, 0], [0, -1], [-1, 0]]
        q = deque()

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count+=1
                    q.append([i, j])
                    grid[i][j] == '0'
                    while q:
                        curr = q.popleft()
                        for dir in dirs:
                            nr = curr[0]+dir[0]
                            nc = curr[1]+dir[1]
                            if(nr >= 0 and nc >= 0 and nr < m and nc < n and grid[nr][nc] == '1'):
                                q.append([nr, nc])
                                grid[nr][nc] = '0'
        return count

#Approach 2: DFS
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid == None or len(grid) == 0:
            return 0
        m = len(grid)
        n = len(grid[0])
        count = 0
        dirs = [[0,1], [1, 0], [0, -1], [-1, 0]]
        q = deque()

        def dfs(i, j):
            #base
            if(i < 0 or j < 0 or i == m or j == n or grid[i][j] == '0'):
                return

            #logic
            grid[i][j] = '0'
            for dir in dirs:
                nr = i + dir[0]
                nc = j + dir[1]
                dfs(nr, nc)

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count+=1
                    dfs(i, j)
        return count



