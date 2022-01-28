
# tc : O(MN) SC:O(MN) worse case if entire grid has no island
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        count = 0
        
        self.dirs =[ [1,0],[0,1],[-1,0],[0,-1]]
        
        def bfs(grid, r, c):
            q = []
            q.append([r,c])
            
            while q:
                i,j = q.pop(0)
                grid[i][j] = "0"
                #print("in q")
                for direc in self.dirs:
                    #print("in for")
                    new_i = i+direc[0]
                    new_j = j+direc[1]
                    #print(new_i, new_j)
                    if new_i>=0 and new_j>= 0 and new_j < len(grid[0]) and new_i < len(grid) and grid[new_i][new_j]=="1":
                        #print("add in q")
                        q.append([new_i, new_j])
        
        def dfs(grid, r, c):
            # base
            if r<0 or c<0 or c == len(grid[0]) or r == len(grid) or grid[r][c]=="0":
                return
            # logic 
            grid[r][c] = "0"
            for direc in self.dirs:
                new_i = r + direc[0]
                new_j = c + direc[1]
                dfs(grid, new_i, new_j)
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    count = count + 1
                    dfs(grid, i, j)
        return count 
