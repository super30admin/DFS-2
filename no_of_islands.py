# Time Complexity : O(m*n) where m*n are dimensions of imput matrix
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
# No

# Your code here along with comments explaining your approach
# I start iteration at index 0, 0. Whenever I find 1 we increment result by 1 and make all connected 1 to 0
# I return the result once we iterate all the cells in matrix

#https://leetcode.com/problems/number-of-islands/
from collections import deque

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        rows = len(grid)
        columns = len(grid[0])
        islands = 0
        q = deque()
        directions = [(0,-1),(1,0),(0,1),(-1,0)]
        
        for i in range(rows):
            for j in range(columns):
                if grid[i][j] == "1":
                    islands += 1
                    grid[i][j] = "0"
                    q.append((i,j))
                    while len(q) > 0:
                        current = q.popleft()
                        for direction in directions:
                            x = current[0] + direction[0]
                            y = current[1] + direction[1]
                            if x>=0 and y>=0 and x<rows and y<columns and grid[x][y]=="1":
                                grid[x][y] = "0"
                                q.append((x,y))
                                
        return islands