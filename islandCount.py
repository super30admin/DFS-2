"""
200. Number of Islands

Time = O(m*n) where m = num of rows, n= num of cols
space = O(m*n) where m = num of rows, n= num of cols
Successfully excecuted on leetcode


Approach --
1. DFS recursive
2. Iterate through matrix and when cell value = 1, check all neighbors using dfs
3. In dfs, keep iterating untill you hit the 0.
4. Once you visit the node, encode it by marking it 0.
5. Return the count of dfs calls, cause even if all the neighbors are zero it is still the island.
"""


class Island:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        if not grid:
            return 0
        
        rows = len(grid)
        cols = len(grid[0])
        numIsland = 0
        
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == "1":
                    numIsland += self.dfs(i,j,grid)
        return numIsland
    
    
    
    def dfs(self,i,j,grid):
        if i<0 or i>=len(grid) or j<0 or j>=len(gird[0]) or matrix[i][j] == "0":
            return
        
        grid[i][j] == "0"
        self.dfs(i+1,j,grid)
        self.dfs(i,j+1,grid)
        self.dfs(i-1,j,grid)
        self.dfs(i,j-1,grid)
        return 1