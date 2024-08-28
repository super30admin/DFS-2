#########200. Number of Islands############################################################################
// Time Complexity : O(n*m)
// Space Complexity : O(1) -> as we are updating grid itself
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no problem

// Your code here along with comments explaining your approach in three sentences only
We will traverse through all element and we will encounter 1 we will apply DFS to check how many 1 are connected to it, also while searching for other 1 we will change current 1 to 0 this will help to ensure that once any island is counted it is not recounted and also we will keep a counter when ever 1 set of dis is complete and we look out for another 1 than counter is increased

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        dirlist=[[0,1],[1,0],[0,-1],[-1,0]]
        r,c=len(grid),len(grid[0])
        numi=0
        for i in range(r):
            for j in range(c):
                if grid[i][j]=='1':
                    self.dfs(grid, i, j, dirlist)
                    #print(i,j,'grid: ',grid)
                    numi+=1
        #print(numi)
        return numi

        
    def dfs(self,grid,r,c,dirlist):
        #base

        if r<0 or c<0 or r==len(grid) or c==len(grid[0]) or grid[r][c]=='0':
            return

        #logic
        grid[r][c]='0'
        for i in dirlist:
            nr,nc=r+i[0],c+i[1]
            self.dfs(grid,nr,nc, dirlist)

        
        
