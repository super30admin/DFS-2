def numIslands(self, grid: List[List[str]]) -> int:
    self.dirs=[[0,-1],[-1,0],[0,1],[1,0]]
    self.m=len(grid)
    self.n=len(grid[0])
    count=0

    q=collections.deque()

    for i in range(self.m):
        for j in range(self.n):
            if grid[i][j]=="1":
                count+=1
                grid[i][j]="0"

                q.append([i,j])

            while q:
                curr=q.popleft()
                for dir in self.dirs:
                    r=dir[0]+curr[0]
                    c=dir[1]+curr[1]

                    if r>=0 and c>=0 and r<self.m and c<self.n and grid[r][c]=="1":
                        grid[r][c]="0"
                        q.append([r,c])
    return count

        