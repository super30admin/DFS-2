# Time Complexity : O(m x n) time for BFS & DFS
# Space Complexity : O(mn) space for BFS & DFS, for the longest diagonal in worst case.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class DFS:
    dirs = [[0,1],[0,-1],[1,0],[-1,0]]
    def numIslands(self,grid):
        if not grid :
            return 0 
        m , n = len(grid) , len(grid[0])
        result = 0 
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                   result += 1 
                   self.__dfs(grid,i,j)
        return result 
    
    def __dfs(self,grid,i,j):
        # Base 
        if i < 0 or i == len(grid) or j < 0 or j == len(grid[0]) or grid[i][j] == '0':
            return 
        
        # Logic 
        grid[i][j] = '0'
        for dir in self.dirs:
            r = i + dir[0]
            c = j + dir[1]
            self.__dfs(grid,r,c)
         
class BFS: 
    def numIslands(self,grid):
        if not grid:
            return 0 
        result = 0 
        m , n = len(grid) , len(grid[0])
        dirs = [[1,0],[-1,0],[0,1],[0,-1]]
        q = []
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    result += 1 
                    grid[i][j] = '0'
                    q.append([i,j])
                    while q:
                        curr = q.pop(0)
                        for dir in dirs:
                            r = curr[0] + dir[0]
                            c = curr[1] + dir[1]
                            if r >= 0 and r < m and c >= 0 and c < n and grid[r][c] =='1':
                                grid[r][c] = '0'
                                q.append([r,c])
        return result 
                    
if __name__ == "__main__":
    d = DFS()
    grid = [["1","1","1","1","0"],["1","1","0","1","0"],["1","0","1","0","0"],["0","0","0","0","1"]] 
    res = d.numIslands(grid)
    print("No of Islands by DFS method = ",res)
    
    # ------------------------------------------------------------------------------------------
    
    b = BFS()
    grid1 = [["1","1","1","1","0"],["1","1","0","1","0"],["1","0","1","0","0"],["0","0","0","0","1"]] 
    r = b.numIslands(grid1)
    print("No if Islands using BFS method = ",r)