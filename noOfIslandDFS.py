#DFS
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        # DFS solution
        # Time Complexity: O(m*n)
        # Space Complexity: O(m*n)
        def dfs(grid,r,c):
            if not(r>=0 and c>=0 and r<len(grid) and c<len(grid[0]) and grid[r][c]=="1"):
                return
            grid[r][c] = "0"
            dirs = [(0,1),(0,-1),(1,0),(-1,0)]
            for i in dirs:
                j = r + i[0]
                k = c + i[1]
                dfs(grid,j,k)
            return
        
        c1=0
        for i in range(0,len(grid)):
            for j in range(0,len(grid[0])):
                if(grid[i][j]=="1"): 
                    c1+=1
                    dfs(grid,i,j)
        
        return c1
