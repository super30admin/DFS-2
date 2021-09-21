"""
## Problem1 (https://leetcode.com/problems/number-of-islands/)
Ran on leetcode- yes
We will just do dfs on the matrix for every value 1 encountered , we will inspect its neigbours in 4 directions
and then we will see which neigbours are 1 with few other conditions finally we will append these results in an array
and return them.
Complexity- TimeO(m*n)
SpaceO(mn) due to queue being used. Hope im correct on the space???????????????
"""

#
# def numIslandsBFS(self, grid):
#     """
#     :type grid: List[List[str]]
#     :rtype: int
#     """
#     if not grid or not grid[0]:
#         return 0
#
#     m, n = len(grid), len(grid[0])
#     count = 0
#     for i in xrange(m):
#         for j in xrange(n):
#             if grid[i][j] == '1':
#                 self.bfs(grid, i, j)
#                 count += 1
#     return count
#
#
# def bfs(self, grid, r, c):
#     queue = collections.deque()
#     queue.append((r, c))
#     grid[r][c] = '0'
#     while queue:
#         directions = [(0, 1), (0, -1), (-1, 0), (1, 0)]
#         r, c = queue.popleft()
#         for d in directions:
#             nr, nc = r + d[0], c + d[1]
#             if self.is_valid(grid, nr, nc) and grid[nr][nc] == '1':
#                 queue.append((nr, nc))
#                 grid[nr][nc] = '0'
#
#     def numIslands(self, grid: List[List[str]]) -> int:
#         if not grid:
#             return 0
#         rows = len(grid)
#         cols = len(grid[0])
#         visited = set()
#         islands = 0
#         for r in range(rows):
#             for c in range(cols):
#                 if grid[r][c] == "1" and (r, c) not in visited:
#                     self.bfs(grid, r, c, visited, rows, cols)
#                     islands += 1
#                     print(islands)
#         return islands
#
#     def bfs(self, grid, r, c, visited, rows, cols):
#         q = collections.deque()
#         visited.add((r, c))
#         q.append((r, c))
#
#         while q:
#             row, col = q.popleft()
#             directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
#             for dr, dc in directions:
#                 if (r + dr in range(rows) and c + dc in range(cols) and grid[r + dr][c + dc] == "1" and r + dr,
#                     c + dc not in visited):
#                     q.append((r + dr, c + dc))
#                     visited.add((r + dr, c + dc))
#
from collections import deque
class Solution:
    def numIslands(self, grid) -> int:
        if not grid:
            return 0
        count=0
        rows=len(grid)
        columns=len(grid[0])
        for r in range(rows):
            for c in range(columns):
                if grid[r][c]=="1":
                    self.bfs(grid,r,c)
                    count+=1
        return count

    def bfs(self,grid ,r,c):
        rows=len(grid)
        columns=len(grid[0])
        q=deque()
        grid[r][c]=="2"
        q.append((r,c))
        while q:
            dirs = [[0, 1], [0, -1], [-1, 0], [1, 0]]
            r,c=q.popleft()
            for d in dirs:
                nr=d[0]+r
                nc=d[1]+c
                if 0 <= nr < rows and 0 <= nc < columns and grid[nr][nc] == "1":
                    q.append((nr, nc))
                    grid[nr][nc]="2"


grid = [
        ["1", "1", "1", "1", "0"],
        ["1", "1", "0", "1", "0"],
        ["1", "1", "0", "0", "0"],
        ["0", "0", "0", "0", "0"]
    ]
solve = Solution()
print(solve.numIslands(grid))

    # for dir in dirs:
        #     nr=dir[0]+r
        #     nc=dir[1]+c
        #









