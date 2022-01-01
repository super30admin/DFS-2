class Solution:
    
    def dfs(self,grid,i,j,m,n):
        que=collections.deque()
        que.append((i,j))
        grid[i][j]="1"
        while que:
            cur=que.popleft()
            for x,y in [[0,1],[0,-1],[1,0],[-1,0]]:
                newx=cur[0]+x
                newy=cur[1]+y
                if newx>=0 and newx<m and newy>=0 and newy<n and grid[newx][newy]=="1":
                    grid[newx][newy]="0"
                    que.append((newx,newy))
        
    
    def numIslands(self, grid: List[List[str]]) -> int:
        count=0
        if grid is None or len(grid)==0:
            return count
        
        m,n=len(grid),len(grid[0])
        
        for i in range(m):
            for j in range(n):
                if grid[i][j]=="1":
                    count+=1
                    self.dfs(grid,i,j,m,n)
        return count
        