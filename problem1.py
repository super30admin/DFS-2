#Time Complexity O(m * n)
#Space Complexity Min( O(n),O(m))

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        #check none conditions
        if grid==None or len(grid)==0:
            return 0
        
        m = len(grid)
        n = len(grid[0])
        
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        
        count = 0
        q = []
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count+=1
                    # Adding the BFS Logic
                    q.append([i,j])
                    grid[i][j] = 0
                    while len(q)>0:
                        #Current Node
                        curr = q.pop(0)
                        for x in dirs:
                            r = curr[0] + x[0]
                            c = curr[1] + x[1]
                            if r >= 0 and r < m and  c >=0 and c<n and grid[r][c]=="1":
                                q.append([r,c])
                                grid[r][c] = '0'
        return count
                    
        
        
        
