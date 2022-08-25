"""
Count the number of Islands

We will mark all the connected components of 1s as 0s so we dont process them again. and continue looking for 1s
Both BFS and DFS can be used.
TC = O(2mn) - in worst case,i.e. all 1s, the entire matrix will be traversed only twice. for the first 1, all the 1s will be flipped to 0
after that, in the next iteration as there are no 1s left, there will be no other DFS initiated
SC = O(mn)

"""
#M1 - DFS
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if len(grid)==0 or grid is None:
            return None
        m = len(grid)
        n = len(grid[0])
        count = 0
        
        dirs = [[-1,0],[0,1],[1,0],[0,-1]]
        
        for i in range(m):
            for j in range(n):
                
                if grid[i][j]=="1":
                    print('found')
                    count+=1
                    self.dfs(grid, i, j, m, n, dirs)
        return count
    
    
    def dfs(self, grid, i, j, m, n, dirs):
        #// base
        if(i<0 or j<0 or i==m or j==n or grid[i][j]=="0"):
            return
        
        #//logic
        grid[i][j]="0"
        for pos in dirs:
            nr = i + pos[0]
            nc = j + pos[1]
            self.dfs(grid, nr, nc, m, n, dirs)

#M2 -  BFS
"""
We will start from a corner and will process all the immediate neighbors - i.e. at any instance the maximum number of elements in the queue will be min(m,n):
m =  number of rows, n = number of columns

[[1,1,(1),1,1,1]
 [1,(1),1,1,1,1]
 [(1),1,1,1,1,1]]

not the (1)

If the BFS is moving diagonally right( or any diagonal manner) - SC = min(m,n)
If it is expanding radially- SC = will keep increasing, exponentially 4,16,...

For doing it using BFS, we will use a queue and put the roots inside the queue if the value is 1    

Whenever we put a node inside the queue, we change its value. Instead of changing it after removing.

"""
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        #bfs
            
        m = len(grid)
        n = len(grid[0])
        dirs = [[-1,0],[0,1],[1,0],[0,-1]]
        rq = deque()
        cq = deque()
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j]=="1":
                    count+=1
                    grid[i][j]="0"
                    rq.append(i)
                    cq.append(j)
                    while len(rq)!=0:
                        cr = rq.popleft()
                        cc = cq.popleft()
                        for pos in dirs:
                            nr = cr+pos[0]
                            nc = cc+pos[1]
                            if nr>=0 and nc >=0 and nr<m and nc<n and grid[nr][nc]=="1":
                               
                                grid[nr][nc]="0"
                                rq.append(nr)
                                cq.append(nc)
                                
                                
        return count
                    
        