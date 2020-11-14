"""
Time complexity O(MxN)
space complexity Min(M,N)
#BFS SOLUTION
"""
class Solution_numIslandsBFS:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid is None or len(grid)==0:
            return 0
        m=len(grid)
        n=len(grid[0])
        q=[]
        count=0
        dirs=[[1,0],[0,1],[-1,0],[0,-1]]
        for i in range(m):
            for j in range(n):
                if grid[i][j]=="1":
                    count+=1
                    q.append([i,j])
                    grid[i][j]="0"
                    while q:
                        curr=q.pop(0)
                        for dir in dirs:
                            r=curr[0]+dir[0]
                            c=curr[1]+dir[1]
                            if(r>=0 and r<m and c>=0 and c<n and grid[r][c]=="1"):
                                q.append([r,c])
                                grid[r][c]="0"
        return count
                                
                    
        