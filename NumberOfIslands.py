---------------------------------- Number of Islands -------------------------------------
# Time Complexity : O(MXN) M is the rows of the grid and N is the cols of the grid
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here to find the number of islands, we will use dfs. when ever we encounter 1 it is land and when ever 
# we encounter 0 it is water, then we found an island and increment the count by 1. we eliminated the visited array by 
# changing the value to 2.



class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        
        
        def dfs(i, j, grid):
            if i<0 or i>len(grid)-1 or j<0 or j>len(grid[0])-1 or grid[i][j] != '1':
                return 
            
            grid[i][j] = '2'
            
            dfs(i+1, j, grid)
            dfs(i-1, j, grid)
            dfs(i, j+1, grid)
            dfs(i, j-1, grid)
        
            
        
        m = len(grid)
        n = len(grid[0])
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    dfs(i,j,grid)
                    count +=1
        return count