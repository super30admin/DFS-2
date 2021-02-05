#Time complexity:O(2mn)
#Space complexity:O(min(m,n))

#BFS approach

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid)==0:                                                    ##if the grid is empty return the grid
            return grid
        m=len(grid)                                                         #obtain the number of rows and columns in the grid
        n=len(grid[0])
        dirs=[[1,0],[-1,0],[0,1],[0,-1]]                                     #initializing the adjacent positions
        count=0                                                             #Initialize the count variable
        d=deque()                                                           #initializing a queue
        for i in range(m):                                                  #for each element in the grid
            for j in range(n):
                if grid[i][j]=='1':                                         #if the value at the position is '1'
                    d.append(i)                                             #push the row and column value into the queue
                    d.append(j)
                    count+=1                                                #increment the count by one
                    grid[i][j]='0'                                          #change the value at the position from '1' to '0'
                    while d:                                                #while the queue is not empty
                        cr=d.popleft()                                      #obtain the row and column index from the queue
                        cc=d.popleft()
                        for dr in dirs:                                     #obatin the adjacent positions of the current positions
                            r=cr+dr[0]
                            c=cc+dr[1]
                            if 0<=r<m and 0<=c<n and grid[r][c]=='1':       #if the adjacent position is within the grid and the value is '1'
                                d.append(r)                                 #add the position into the queue and change the grid vbalue to '0'
                                d.append(c)
                                grid[r][c]='0'
        return count                                                        #return count

#DFS approach
#Time complexity:O(2mn)
#Space complexity:O(mn)

class Solution:
    global count,m,n
    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid)==0:                                                      #if the grid is empty return the grid
            return grid
        self.m=len(grid)                                                      #obtain the number of rows and columns in the grid
        self.n=len(grid[0])
        self.count=0                                                           #Initialize the count variable
        for i in range(self.m):                                                 #for each element in the grid
            for j in range(self.n):
                if grid[i][j]=='1':                                             #if the value at the position is '1'
                    self.count+=1                                               #increment count and call the recursive dfs call
                    self.dfs(grid,i,j)
        return self.count                                                       #return the count variable
    
    def dfs(self,grid:List[List[str]],i:int,j:int)->None:
        if i<0 or i==self.m or j<0 or j==self.n or grid[i][j]=='0':             # if the i and j values are not within the grid or the valur at row i and column j is '0' return
            return
        grid[i][j]='0'                                                          #else change the '1' to '0'
        dirs=[[1,0],[-1,0],[0,1],[0,-1]]                                        #initializing the adjacent positions
        for dr in dirs:                                                         #for every adjacent direction call the recursive dfs call
                r=i+dr[0]
                c=j+dr[1]
                self.dfs(grid,r,c)