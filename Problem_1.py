"""
Time Complexity : O(m*n)- for both BFS and DFS
Space Complexity : O(m*n)- for DFS and O(min(m,n)) for BFS
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
I have done both BFS and DFS here and commented the BFS solution. For BFS, we traverse through the matrix once,
and whenever we come across any 1, we call our BFS, ie, we start putting neighbors inside the queue and
turn them into 0 untill and unless all the neighbors are 0. Also, we increase the count when we encounter first
1. Similarly, when this queue becomes empty, we again continue our matrix traversal, and again repeat the
process if we encounter any 1. For DFS, similarly, we traverse through the matrix and call DFS as soon as we 
encounter a 1. Inside DfS, we keep o converting the neighbors to 0 and keep on calling DFS on all
neighbors unless all neighbors are 0.
"""


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        count = 0
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1
                    self.dfs(grid, i, j)
        return count

    def dfs(self, grid, i, j):
        if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]) or grid[i][j] == '0':
            return
        dirs = [(0, -1), (-1, 0), (0, 1), (1, 0)]
        grid[i][j] = '0'
        for d in dirs:
            r = d[0]+i
            c = d[1]+j
            self.dfs(grid, r, c)


# from collections import deque
# class Solution:
#     def numIslands(self, grid: List[List[str]]) -> int:
#         if not grid:
#             return 0
#         count=0
#         q=deque()
#         m=len(grid)
#         n=len(grid[0])
#         dirs=[(0,-1),(-1,0),(0,1),(1,0)]
#         for i in range(m):
#             for j in range(n):
#                 if grid[i][j]=='1':
#                     count+=1
#                     q.append((i,j))
#                     grid[i][j]='0'
#                     while q:
#                         curr=q.popleft()
#                         for d in dirs:
#                             r=d[0]+curr[0]
#                             c=d[1]+curr[1]
#                             if r>=0 and r<m and c>=0 and c<n and grid[r][c]=='1':
#                                 q.append((r,c))
#                                 grid[r][c]='0'
#         return count
