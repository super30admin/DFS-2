class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        count = 0
        self.dirs = [[1,0], [-1,0], [0,1], [0,-1]]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    count +=1
                    self.dfs(grid, i, j, m, n)
        return count
        
    def dfs(self, grid, r, c, m, n):
        #Base

        #logic
        grid[r][c] = "0"
        for d in self.dirs:
            nr = r + d[0]
            nc = c + d[1]
            if nr >=0 and nr < m and nc >=0 and nc < n and grid[nr][nc] == "1":
                self.dfs(grid, nr, nc, m, n)
            
#Time complexity and space complexity is O(n)
#Approach used: increasing count on encountering a "1" and marking it "0" and going over its neighbours unless all the "1s" in the vicinity are not marked "0"