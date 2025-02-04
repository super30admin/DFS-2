#Time Complexity : O(m*n)
#Space Complexity : O(1)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        dirs = [[-1,0], [0,-1], [1, 0], [0,1]]
        m = len(grid)
        n = len(grid[0])
        def dfs(grid, i, j, dirs):
            m = len(grid)
            n = len(grid[0])
            if i < 0 or j < 0 or i >= m or j >= n or grid[i][j] == '0':
                return
            grid[i][j] = '0'
            for dir1 in dirs:
                r = i + dir1[0]
                c = j + dir1[1]
                dfs(grid, r, c, dirs)                 
        
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count +=1
                    dfs(grid, i, j, dirs)
        return count

        