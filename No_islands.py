// Time Complexity : o(mn)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid)==0:
            return 0
        q=[]
        row=len(grid)
        col=len(grid[0])
        count=0
        dir={(0,-1),(-1,0),(0,1),(1,0)}
        for i in range(row):
            for j in range(col):
                if(grid[i][j]=='1'):
                    count+=1
                    q.append((i,j))
                    grid[i][j]='0'
                    while q:
                        node=q.pop()
                        for d in dir:
                            r=node[0]+d[0]
                            c=node[1]+d[1]
                            if((r>=0) and (r<row) and (c>=0) and(c<col) and (grid[r][c]=='1')):
                                grid[r][c]='0'
                                q.append((r,c))
        return count
                   
            
