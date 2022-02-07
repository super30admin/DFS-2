# Time Complexity : O(MN)
# Space Complexity : O(MN) 

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approach


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        res = 0
        row = len(grid)
        col = len(grid[0])
        
        visited = [[0 for x in range(col)] for y in range(row)]
        
        def perm(i, j):

            if i < 0 or i >= row or j < 0 or j >= col or grid[i][j] == "0":
                return
            

            if visited[i][j]:
                return
            visited[i][j] = 1

            return perm(i-1, j) or perm(i+1, j) or perm(i, j-1) or perm(i, j+1)
        
        
        for x in range(row):
            for y in range(col):

                if grid[x][y] == "1" and not visited[x][y]:
                    perm(x, y)
                    res += 1
                    
        return res
