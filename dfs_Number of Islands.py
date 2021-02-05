#time: O(mxn)
#space: O(min(m,n))
#leetcode: yes

#dfs

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if(grid==[]):
            return 0
        m=len(grid)
        n=len(grid[0])
        count=0
        def dfs(grid,r,c):
            if(r>=0 and r<m and c>=0 and c<n and grid[r][c]=='1'):
                grid[r][c]='0'
                for d in dr:
                    row=d[0]+r
                    column=d[1]+c
                    dfs(grid,row,column)
            else:
                return
            
                
        dr=[[0,1],[1,0],[-1,0],[0,-1]]
        for i in range(m):
            for j in range(n):
                if(grid[i][j]=='1'):
                    count+=1
                    dfs(grid,i,j)
                        
        return count
    
        
            
            