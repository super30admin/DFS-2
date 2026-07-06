# Problem1 (https://leetcode.com/problems/number-of-islands/)
# Time Complexity: O(m x n)
# Space Complexity: O(m x n)
# Approach: We loop through every cell in the grid one time
# Whenever we find a land cell that is not visited yet we treat it as a new island and increase the count
# We then use dfs to visit every connected land cell around it and mark it as water so we never count it again
# The dfs call stack can grow as deep as the total number of cells if the whole grid is one big island which is why space is also O(m x n)

class Solution:s
    def numIslands(self, grid: List[List[str]]) -> int:
        # store the four directions we can move in from any cell(up, down, left, right in that order)
        self.directions = [[-1,0],[1,0],[0,-1],[0,1]]  
        self.m = len(grid)             # total number of rows in the grid
        self.n = len(grid[0])          # total number of columns in the grid, taken from the first row
    
        count = 0       # this keeps track of how many islands we have found so far

        
        for i in range(self.m):     # go through every row          
            for j in range(self.n):     # go through every column in that row
                # if we find a land cell that has not been visited yet
                if grid[i][j]=='1':
                    # this is the start of a brand new island so we count it
                    count +=1
                    # now sink this whole island so we do not count it again later
                    self.dfs(grid,i,j)

        return count
    
    def dfs(self,grid,i,j):
        # stop here if we are out of bounds on any side or if the current cell is water or already visited land
        if i<0 or j<0 or i == self.m or j ==self.n or grid[i][j]!='1':
            return
        
        # mark this cell as visited by turning it into water
        # this way we never come back to it again
        grid[i][j]='0'

        # now check all four neighbors of this cell
        for dir in self.directions:
            # work out the row of the neighbor in this direction
            row = dir[0]+i
            # work out the column of the neighbor in this direction
            column = dir[1]+j
            # recursively visit that neighbor to see if it is also land
            self.dfs(grid,row,column)