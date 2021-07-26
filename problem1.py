from collections import deque
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        #BFS
        if len(grid)==0:
            return 0
        dirs=[(-1,0),(0,-1),(1,0),(0,1)]
        count=0
        queue=deque()
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]=="1":
                    
                    count+=1
                    grid[i][j]="0"
                    queue.append([i,j])
                    while(len(queue)>0):
                        r,c=queue.popleft()
                        for rd,cd in dirs:
                            r1=r+rd
                            c1=c+cd
                            if 0<=r1<len(grid) and 0<=c1<len(grid[0]) and grid[r1][c1]=="1":
                                grid[r1][c1]="0"
                                queue.append([r1,c1])
        
            
        return count
        #Time O(n*m)
        #Space O(min(m,n))
        
        #DFS
        # count=0
        # def dfs(row,col):
        #     if 0<=row<len(grid) and 0<=col<len(grid[0]) and grid[row][col]=="1":
        #         grid[row][col]="0"
        #         dirs=[(-1,0),(0,-1),(1,0),(0,1)]
        #         for x,y in dirs:
        #             dfs(x+row,y+col)
        # for i in range(len(grid)):
        #     for j in range(len(grid[0])):
        #         if grid[i][j]=="1":
        #             count+=1
        #             dfs(i,j)
        # return count
        # #Time O(m*n)
        # #Space O(m*n)
            
        
