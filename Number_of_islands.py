class Solution:
#O(n)/o(1) tc and spc


    def dfs(self,grid,i,j):
        if i<0 or j<0 or  not i<len(grid) or not j<len(grid[i]) or grid[i][j]=='0':
            return 0

        grid[i][j]='0'
        self.dfs(grid,i+1,j)
        self.dfs(grid,i-1,j)
        self.dfs(grid,i,j+1)
        self.dfs(grid,i,j-1)

        return 1
    
    
    def numIslands(self, grid: List[List[str]]) -> int:
        number_of_islands=0

        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j]=='1':  # we go inside the loop only when we see a "1"
                    # to avoid parsing those '1''s inside the same island we impute them with 0.
                    number_of_islands+=self.dfs(grid,i,j)

        return number_of_islands
