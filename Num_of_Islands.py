# TC: O(M X N)
# SC: O(M X N)

class Solution:
    m=0
    n=0
    dir1=[[0,1],[1,0],[0,-1],[-1,0]]
    def bfs(self,grid,i,j):
        print(str(i)+" "+str(j))
        q=deque()
        q.append((i,j))
        grid[i][j]="0"
        while q:
            hr,hc=q.popleft()
            for k in range(0,len(self.dir1)):
                r=hr+self.dir1[k][0]
                c=hc+self.dir1[k][1]

                if r>=0 and c>=0 and r<self.m and c<self.n and grid[r][c]=="1":
                    grid[r][c]="0"
                    q.append((r,c))

    def dfs(self,grid,i,j):
        grid[i][j]="0"

        for k in range(0,len(self.dir1)):
            r=i+self.dir1[k][0]
            c=j+self.dir1[k][1]

            if r>=0 and c>=0 and r<self.m and c<self.n and grid[r][c]=="1":
                self.dfs(grid,r,c)

    def numIslands(self, grid: List[List[str]]) -> int:
        self.m=len(grid)
        self.n=len(grid[0])
        count1=0
        for i in range(0,self.m):
            for j in range(0,self.n):
                if grid[i][j]=="1":
                    count1+=1
                    self.dfs(grid,i,j)
        
        print(grid)
        return count1

        