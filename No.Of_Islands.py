// Time Complexity : O(M*N)
// Space Complexity :O(H) - recursion stack
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach




def numIslands(self, grid: List[List[str]]) -> int:
        
        q = deque()
        count = 0
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    self.dfs(grid,i,j)
                    count += 1
        return count
                    
    
    def dfs(self,grid,i,j):
        grid[i][j] = "0"
        dirs = [[-1,0], [1,0], [0,1], [0,-1]]
        for d in dirs:
            r = i + d[0]
            c = j + d[1]

            if (r>=0 and r<len(grid) and c>=0 and c<len(grid[0]) and grid[r][c]=="1"):
                self.dfs(grid, r, c)
    
