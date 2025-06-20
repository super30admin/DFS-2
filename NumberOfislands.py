# // Time Complexity : bfs o(2m*n) dfs same
# // Space Complexity : bfs diagonal min(n,n) dfs (m*n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : implementting dfs


# // Your code here along with comments explaining your approach
# idea for bfs is to spot the first 1 (represnting land) and then apply bfs to every connected 1 . Tactic should be to make the 1 as 0 so that it cannot be visited again 
# 

from typing import List,collections
# class Solution:
#     def numIslands(self, grid: List[List[str]]) -> int:
#         m,n,q,cnt=len(grid),len(grid[0]),collections.deque(),0
#         dir = [[0,1],[0,-1],[1,0],[-1,0]]
#         for i in range(m):
#             for j in range(n):
#                 if grid[i][j]== "1":
#                     #apply bfs change the cell to 0 soo we dont execute again
#                     q.append((i,j))
#                     cnt+=1
#                     grid[i][j] = "0"
#                     while q:
#                         r,c = q.popleft()
#                         for x,y in dir:
#                             nr = r+x
#                             nc = c+y
#                             if nr>=0 and nc>=0 and nr<m and nc<n and grid[nr][nc] == "1":
#                                 grid[nr][nc] = "0"
#                                 q.append((nr,nc))
#         return cnt



# DFS
class Solution:

    def __init__(self):
        self.cnt = 0
        self.dir = [[0,1],[0,-1],[1,0],[-1,0]]
    def numIslands(self, grid: List[List[str]]) -> int:
        m,n=len(grid),len(grid[0])

        def dfs(grid, r, c):
            #base
            if r<0 or c<0 or r >len(grid)-1 or c >len(grid[0])-1 or grid[r][c] == '0' : return 
            #logic
            grid[r][c] = '0'
            for x,y in self.dir:
                nr = x +r
                nc = y+c
                dfs(grid, nr,nc)

        for i in range(m):
            for j in range(n):
                if grid[i][j]== "1":
                    self.cnt+=1  
                    #apply dfs from here        
                    dfs(grid, i,j)                 
        return self.cnt



        



         