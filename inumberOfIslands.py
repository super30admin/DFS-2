'''
Time Complexity -->
O(m*n)

Spacec COmplexity -->
O(m*n)  stack space
'''
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        
        
        
        def dfs(r,c):
            if r<0 or r>=m or c<0 or c>=n or grid[r][c]!='1':
                return
            grid[r][c]='0'
            #print(grid)
            for d in direction:
                new_row = d[0]+r
                new_col = d[1]+c
                dfs(new_row, new_col)
            
        
        
        m = len(grid)
        n = len(grid[0])
        
        direction = [[-1,0],[1,0],[0,-1],[0,1]]  #up, down, left, right
        
        
        
        
        if m==1 and n==1:
            if grid[0][0]=="1":
                return 1
            return 0
        #DFS approach can be applied
        cout_islands = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j]=='1':
                    dfs(i, j)
                    #print(grid)
                    cout_islands+=1
        return cout_islands
                
                
                
        