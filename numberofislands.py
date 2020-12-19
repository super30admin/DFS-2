class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        #if '1' at grid location>>confirmed island >>just traverse to find how connected big island it is and skip recounting
        #dfs
        #(O(m*n)) time>> if all 1s -all nodes visited in dfs loop O(m*n)
        #>>but in main traverse loop>since all are visited nodes>>no need to run
        
        self.m=len(grid)
        self.n=len(grid[0])
        self.dirs=[[-1,0],[0,1],[1,0],[0,-1]]
        count=0
        for i in range(self.m):
            for j in range(self.n):
                
                def dfs(i,j):
                    for dir in self.dirs:
                        r=i+dir[0]
                        c=j+dir[1]
                        if r>=0 and r<self.m and c>=0 and c<self.n and grid[r][c]=='1':
                            grid[r][c]='2'
                            dfs(r,c)
                            
                #confirmed island>>increase count>>mark visited>>continue dfs 
                if grid[i][j]=='1':
                    grid[i][j]='2'
                    dfs(i,j)
                    count+=1
        return count
        
            