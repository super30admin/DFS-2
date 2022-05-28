'''
// Time Complexity : 0(mn) -- end up traversing all the nodes
// Space Complexity : 0(max(m,n)) -- ayg cases, in worst case 0(mn) i.e. all nodes inside the 
recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
'''

class Solution:
    
    def dfsWay(self,i,j,grid,dirMatrix):
        
        # Set grid[i][j] = "2"
        grid[i][j] = "2"
        
        # Iterate the dirMatrix
        for dir in dirMatrix:
            
            temp_i = dir[0] + i
            temp_j = dir[1] + j
            
            # Check bounds and condition
            if (temp_i>=0 and temp_i < len(grid)) and (temp_j>=0 and temp_j < len(grid[0])) and (grid[temp_i][temp_j] == "1"):
                
                # Recursively call dfsWay
                self.dfsWay(temp_i,temp_j,grid,dirMatrix)
    
    def numIslands(self, grid: List[List[str]]) -> int:
        
        # set island count
        island = 0
        
        # Initialize dirMatrix
        dirMatrix = [
            [0,1], # right
            [0,-1], # left
            [1,0], # bottom
            [-1,0] # top
        ]
        
        # Iterate the grid
        for i in range(0,len(grid)):
            for j in range(0,len(grid[0])):
                
                # Check if grid[i][j] == 1
                if grid[i][j] == "1":
                    
                    # found my island
                    island += 1
                    # print('\nCurrent island count is:\t',island)
                    
                    # Call dfsWay function
                    self.dfsWay(i,j,grid,dirMatrix)
        
        # Print the mutated grid
        # print('Mutated Grid is:\t',grid)
        
        # return the island 
        return island