#Time Complexity : O(N)), N being the number of nodes in the tree. 
#Space Complexity : O(N), N being the number of nodes in the tree. 
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Was stuck on how to approach the strategy at first. 
#Had to look at solution. 
#Your code here along with comments explaining your approach in three sentences only
'''Using DFS and directions array, if 1 is found, increase count and turn to 0 and all adjacent 
1s. 
'''
class Solution:
    #initialize values.
    def __init__(self):
        self.directions = [[-1,0],[1,0],[0,1],[0,-1]]
        self.count = 0
    #finding all adjacent ones. 
    def dfs(self, grid, i, j):
        if i<0 or i>=len(grid) or j<0 or j>=len(grid[0]):
            return 
        else:
            if grid[i][j]=="1":
                grid[i][j] = "0"
                for d in self.directions:
                    r=i+d[0]
                    c=j+d[1]
                    self.dfs(grid, r, c)

    def numIslands(self, grid: List[List[str]]) -> int:
        #for all values in grid, add count and call dfs if 1. 
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]=="1":
                    self.count = self.count+1
                    self.dfs(grid, i, j)
        return self.count