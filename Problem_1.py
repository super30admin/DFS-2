# Time Complexity : O(m*n)
# Space Complexity : O(min(m, n))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# BFS
from collections import deque


class Solution:
    def numIslands(self, grid: list[list[str]]) -> int:
        dirs = [[-1, 0], [0, -1], [1, 0], [0, 1]]
        m = len(grid)
        n = len(grid[0])
        queue = deque()
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    queue.append([i, j])
                    count += 1
                    while queue:
                        pop = queue.popleft()
                        grid[pop[0]][pop[1]] = '0'
                        for x in dirs:
                            nr = x[0] + pop[0]
                            nc = x[1] + pop[1]
                            if 0 <= nr < m and 0 <= nc < n and grid[nr][nc] == '1':
                                queue.append([nr, nc])
                                grid[nr][nc] = '0'
        return count


print(Solution().numIslands([["1", "1", "1", "1", "0"], ["1", "1", "0", "1", "0"], ["1", "1", "0", "0", "0"], ["0", "0", "0", "0", "0"]]))

# DFS
# TC: O((m*n)); Auxilary SC: O(1), Recursive SC: O(m*n)
# class Solution:
#     def dfs(self, grid, i, j, m, n):
#         # base
#         if i < 0 or j < 0 or i == m or j == n or grid[i][j] == '0':
#             return
#         # logic
#         grid[i][j] = '0'
#         for x in self.dirs:
#             nr = x[0] + i
#             nc = x[1] + j
#             self.dfs(grid, nr, nc, m, n)
#
#     def numIslands(self, grid: list[list[str]]) -> int:
#         self.dirs = [[-1, 0], [0, -1], [1, 0], [0, 1]]
#         self.count = 0
#         m = len(grid)
#         n = len(grid[0])
#         for i in range(m):
#             for j in range(n):
#                 if grid[i][j] == '1':
#                     self.count += 1
#                     self.dfs(grid, i, j, m, n)
#         return self.count
#
#
# print(Solution().numIslands([["1", "1", "1", "1", "0"], ["1", "1", "0", "1", "0"], ["1", "1", "0", "0", "0"], ["0", "0", "0", "0", "0"]]))
