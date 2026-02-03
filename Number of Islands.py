class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m=len(grid)
        n=len(grid[0])
        queue=[]
        
        count=0

        for i in range(m):
            for j in range(n):
                if grid[i][j]=='1':
                    grid[i][j]='0'
                    queue.append((i,j))
                    count=count+1
                    while len(queue)>0:
                        x,y=queue.pop(0)
                        for dx,dy in [(-1,0),(1,0),(0,-1),(0,1)]:
                            nx,ny=x+dx,y+dy
                            if nx>=0 and ny>=0 and nx<m and ny<n and grid[nx][ny]=='1':
                                grid[nx][ny]='0'
                                queue.append((nx,ny))
        return count
