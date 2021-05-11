## Problem1 (https://leetcode.com/problems/number-of-islands/)

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid==None or len(grid)==0:
            return 0
        self.m = len(grid)
        self.n = len(grid[0])
        count = 0
        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j]=='1':
                    count = count+1
                    self.dfs(grid,i,j)
        return count
    def dfs(self,grid,row,col):
        #base
        if row<0 or col<0 or row==self.m or col==self.n or grid[row][col]!='1':
            return 
        #logic
        grid[row][col]='0'
        dir = [[0,1],[0,-1],[-1,0],[1,0]]
        for i in dir:
            r = row + i[0]
            c = col + i[1]
            self.dfs(grid,r,c)
            
        #Time Complexity: O(mn)
        #Space Complexity: O(mn)
        #Approach: Depth for search technique is used. Traverse the elements in the matrix, get the coordinates of elements where a one is present and pass it to the dfs function. Change the seen nodes to zero in order to mark them visited. 
        