# // Time Complexity : O(n*m + n*m)
# // Space Complexity : O(n*m)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        #directions array
        dirn = [[-1,0],[1,0],[0,1],[0,-1]]
        
        #base cases
        if grid is None or len(grid)==0 or len(grid[0])==0:
            return 0
        
        #counter for number of islands
        numIslands = 0
        
        #making sure your recursive call is always valid
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]=="1":
                    #recursion is called only when "1" is encountered
                    #in any direction if "1" is present, keep changing it to 0
                    #with normal DFS approach and stop when "1" isn't present in any direction
                    #this would mean that we have completed one island, increase count
                    self.recur(grid, i, j, dirn)
                    numIslands += 1
        
        return numIslands
        
    def recur(self, grid, i, j, dirn):
        #change the 1s to 0s
        grid[i][j] = "0"
        
        #check in all four directions
        for d in dirn:
            r = i + d[0]
            c = j + d[1]
            
            #if 1 is present and bound is valid, make recursive call
            if 0<=r<len(grid) and 0<=c<len(grid[0]) and grid[r][c]=="1":
                self.recur(grid, r, c, dirn)