# BFS

""""// Time Complexity : O(m*n)
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid or len(grid) == 0:
            return 0
        q = deque()
        m = len(grid)
        n = len(grid[0])
        count = 0
        d = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1
                    q.append((i, j))
                    grid[i][j] = '0'
                    while q:
                        curr = q.popleft()
                        for k in d:
                            nr = curr[0] + k[0]
                            nc = curr[1] + k[1]
                            if nr >= 0 and nc >= 0 and nr < m and nc < n and grid[nr][nc] == '1':
                                grid[nr][nc] = '0'
                                q.append((nr, nc))
        return count

# DFS
""""// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
# class Solution:
#     def numIslands(self, grid: List[List[str]]) -> int:
#         if not grid or len(grid)==0:
#             return 0
#         m=len(grid)
#         n=len(grid[0])
#         self.d=[[0,1],[1,0],[0,-1],[-1,0]]
#         count=0
#         for i in range(m):
#             for j in range(n):
#                 if grid[i][j]=='1':
#                     count+=1
#                     self.helper(grid, i, j, m, n)
#         return count

#     def helper(self, grid, i, j, m, n):
#         #base
#         if i < 0 or j < 0 or i >= m or j >= n or grid[i][j] == 0:
#             return


#         #logic

#         grid[i][j]=0
#         for k in self.d:
#                 nr = i + k[0]
#                 nc = j + k[1]
#                 if nr >= 0 and nc >= 0 and nr < m and nc < n:
#                     self.helper(grid, nr, nc, m, n)

