# Number of Islands
 
# Time Complexity : O(M*N)
# Space Complexity : O(min(M*N)) 
# Did this code successfully run on Leetcode : Yes with Runtime: 168 ms and Memory Usage: 15.6 MB
# Any problem you faced while coding this : Initally yes, After class understanding no.
# Your code here along with comments explaining your approach
# Approach
"""
Using DFS Approach, in which traversing the grid/matrix and when we 
encounter 1 we perform DFS and convert 1 to 2 as visited and increment the 
count of islands.

"""
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if(grid==None or len(grid)==0): # Edge Case
            return 0
        def dfs(grid,i,j):
            if(i<0 or i>=len(grid) or j<0 or j>=len(grid[i]) or grid[i][j] is not '1'): # base conditions for dfs
                return 0
            grid[i][j]=" "
            directions =[[1,0],[-1,0],[0,1],[0,-1]] # dfs to perform
            for dir in directions:
                r=i+dir[0]
                c=j+dir[1]
                dfs(grid,r,c)
            return 1
        countn=0 # Variable to count the number of islands
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if(grid[i][j]=='1'):
                    countn+=dfs(grid,i,j)
        return countn