"""
//Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        # DFS Solution
        if len(grid)==0:
            return 0
        cnt = 0
        from collections import deque
        q = deque()
        self.m = len(grid)
        self.n = len(grid[0])
        self.dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        for i in range(0,self.m):
            for j in range(0,self.n):
                if grid[i][j]=="1":
                    cnt+=1
                    self.dfs(grid,i,j)
        return cnt
    def dfs(self,grid,row,col):
        #base
        if(row<0 or col<0 or row == self.m or col == self.n or grid[row][col]!="1"):
            return
        grid[row][col]= "0"
        for d in self.dirs:
            nr = row + d[0]
            nc = col + d[1]
            self.dfs(grid,nr,nc)
        
        
        
        # #B.F.S Solution
        # #T.C= O(m*n)
        # #S.C =O(m*n)
        # if len(grid)==0:
        #     return 0
        # cnt = 0
        # from collections import deque
        # q = deque()
        # m = len(grid)
        # n = len(grid[0])
        # dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        # for i in range(0,m):
        #     for j in range(0,n):
        #         if grid[i][j]=="1":
        #             cnt+=1
        #             grid[i][j]="0"
        #             q.append([i,j])
        #             while q:
        #                 cur = q.popleft()
        #                 for d in dirs:
        #                     r =  d[0] + int(cur[0])
        #                     c =  d[1] + int(cur[1])
        #                     if(r>=0 and r< m and c>=0 and c<n and grid[r][c]=="1"):
        #                         q.append([r,c])
        #                         grid[r][c]="0"
        # return cnt