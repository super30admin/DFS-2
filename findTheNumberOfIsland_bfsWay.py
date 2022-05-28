'''
// Time Complexity : 0(mn) -- end up traversing all the nodes
// Space Complexity : 0(min(m,n) -- 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
'''
from collections import deque

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        # Initialze deque
        queue = deque([])
        
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
                    #print('\nCurrent island count is:\t',island)
                    
                    # Append (i,j) to the queue
                    queue.append((i,j))
                    
                    # Update my value
                    grid[i][j] = "2"
                
                    # Iterate queue
                    while len(queue) != 0:
                        
                        # Maintain queue size
                        size = len(queue)

                        # Iterate till my level != size
                        for lvl in range(0,size):

                            # Pop the index from the queue
                            ele = queue.popleft()

                            # Check in all 4-D; dirMatrix
                            for dir in dirMatrix:

                                temp_i = ele[0] + dir[0]
                                temp_j = ele[1] + dir[1]

                                # check the conditional breach
                                if (temp_i >=0 and temp_i < len(grid)) and (temp_j >=0 and temp_j < len(grid[0])) and (grid[temp_i][temp_j] == "1"):

                                    # append (temp_i,temp_j) to the queue
                                    queue.append((temp_i,temp_j))

                                    # update the value
                                    grid[temp_i][temp_j] = "2"

        
        # return the island 
        return island