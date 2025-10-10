# // Time Complexity : O(m*n)
# // Space Complexity : O(1)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        self.n = len(grid)
        self.m = len(grid[0])
        islands = 0
        directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]
        for i in range(self.n):
            for j in range(self.m):
                if(grid[i][j] == "1"):
                    islands += 1
                    self.findLand(grid,i,j,directions)

        return islands    
    
    def findLand(self,grid,i,j,directions):
        
        grid[i][j] = "-1"
        for dx, dy in directions:
            nx, ny = i + dx, j + dy
            if 0 <= nx < self.n and 0 <= ny < self.m :
                if(grid[nx][ny] == "1"):
                    self.findLand(grid,nx,ny,directions)


