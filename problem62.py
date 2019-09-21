# Number of Islands
# Time Complexity: O(N^2) where N is the number of points in the grid
# Space Complexity: O(N) where N is the number of points in the grid
# Approach: Iterate the grid. 
			While iterating if a 1 is encountered, perform DFS and find all points of the island and mark a visited point as 2.
			The number of island count is the number of times the DFS function is called
			
class Solution:
    
    def DFSonIsland(self, i, j, grid):
        for r,c in [(i+1,j), (i,j+1), (i,j-1), (i-1,j)]:
            if 0 <= r < len(grid) and 0 <= c < len(grid[0]):
                if grid[r][c] == '1':
                    grid[r][c] = '2'
                    self.DFSonIsland(r,c,grid)
                
    def numIslands(self, grid: List[List[str]]) -> int:
        
        islands = 0
        for idx_i, i in enumerate(grid):
            for idx_j, j in enumerate(grid[0]):
                if grid[idx_i][idx_j] == '1':
                    self.DFSonIsland(idx_i, idx_j, grid)
                    islands += 1
                    
        return islands
                