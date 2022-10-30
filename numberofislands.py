##Time Complexity : O(m*n)
##Space Complexity : O(m*n)
##Did this code successfully run on Leetcode : Yes
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid: 
            return 0
        rows = len(grid)
        column = len(grid[0])
        visited = set()
        count = 0
        directions=[(-1,0),(0,1),(1,0),(0,-1)]
        def findIsland(x,y):
            for dx, dy in directions:
                nx,ny = x+dx, y+dy
                if 0<=nx<rows and 0<=ny<column and grid[nx][ny]=='1' and (nx,ny) not in visited:
                    visited.add((nx,ny))
                    findIsland(nx,ny)
            
        for x in range(rows):
            for y in range(column):
                if grid[x][y] == '1' and (x,y) not in visited:
                    count +=1
                    visited.add((x,y))
                    findIsland(x,y)         
        return count
        