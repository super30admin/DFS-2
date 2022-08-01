# Time Complexity: O(m*n)
# Space Complexity: O(min(m, n))

# BFS APPROACH
import collections


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid is None or len(grid) == 0:
            return 0
        
        dirs = [[-1, 0], [0, -1], [1, 0], [0, 1]]
        m = len(grid)
        n = len(grid[0])
        total = 0

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    total += 1
                    q = collections.deque()
                    grid[i][j] = '0'
                    q.append([i,j])

                    while q:
                        curr = q.popleft()
                        for dir in dirs:
                            nr = curr[0] + dir[0]
                            nc = curr[1] + dir[1]
                            if nr >= 0 and nr < m and nc >= 0 and nc < n and grid[nr][nc] == '1':    
                                q.append([nr, nc])
                                grid[nr][nc] = '0'
                

        return total



# # DFS APPROACH
# class Solution:
#     def __init__(self):
#         total = 0
#         dirs = []
#         m = 0
#         n = 0
#     def numIslands(self, grid: List[List[str]]) -> int:
#         if grid is None or len(grid) == 0:
#             return 0

#         dirs = [[-1, 0], [0, -1], [1, 0], [0, 1]]
#         m = len(grid)
#         n = len(grid[0])
#         for i in range(m):
#             for j in range(n):
#                 if grid[i][j] == '1':
#                     total += 1
#                     dfs(i, j, grid)

#     def dfs(r, c, grid):
#         if r < 0 or c < 0 or r == m or c == n or grid[r][c] != '1':
#             return
        
#         grid[r][c] = '0'
#         for dir in dirs:
#             nr = dir[0] + r
#             nc = dir[1] + c
#             dfs(nr, nc, grid)
        