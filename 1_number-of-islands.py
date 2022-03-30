// Time Complexity : O(m*n) 
// Space Complexity : O(m*n) recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
'''

'''
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        
        
        global dirs
        dirs=[[0,1],[0,-1],[-1,0],[1,0]]
        
        num_islands=0
        for i in range(0, len(grid)):
            for j in range(0, len(grid[0])):
                if grid[i][j]=='1':
                    self.dfs(grid,i,j)
                    num_islands=num_islands+1
        return num_islands
            
    def dfs(self,grid,i,j):

            #base
            if (i<0 or j<0 or i >= len(grid) or j>= len(grid[0]) or grid[i][j]=='0'):
                return 

            grid[i][j]='0'
            #explore
            for v in dirs:
                r,c=i+v[0],j+v[1]
                self.dfs(grid,r,c)
        