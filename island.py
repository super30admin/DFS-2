
# // Time Complexity :O(m*n)
# // Space Complexity :O(m*n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach




class Solution:
    def __init__(self):
        self.count=0
        self.dirs=[[0,1],[0,-1],[1,0],[-1,0]]
        self.grid=None
    def numIslands(self, grid: List[List[str]]) -> int:
        self.grid=grid
        for i in range(len(self.grid)):
            for j in range(len(self.grid[0])):
                if self.grid[i][j]=='1':
                    self.count+=1
                    self.dfs(i,j)
        return self.count
    def dfs(self,r,c):
        #base
        if(r<0 or c<0 or r==len(self.grid) or c==len(self.grid[0]) or self.grid[r][c]=='0'):
            return
        #logic
        self.grid[r][c]='0'
        for i in self.dirs:
            rn=r+i[0]
            cn=c+i[1]
            self.dfs(rn,cn)
        
                    
        