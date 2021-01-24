class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        # BFS solution
        # Time Complexity: O(m*n)
        # Space Complexity: O(max(m,n))
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        q = deque([])
        c1=0
        for i in range(0,len(grid)):
            for j in range(0,len(grid[0])):
                
                if(grid[i][j]=="1"): 
                    c1+=1 # c1=1
                    grid[i][j] = "0" 
                    q.append((i,j))
                # remove elements that are island 
                while(len(q)>0):
                    n = q.popleft()
                    for k in dirs:
                        r = n[0] + k[0] 
                        c = n[1] + k[1]
                        if(r>=0 and c>=0 and r<len(grid) and c<len(grid[0]) and grid[r][c]=="1"):
                            grid[r][c] = "0"
                            q.append((r,c))
                
        return c1
    
