class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        
        row,cols=len(grid),len(grid[0])
        count=0
        directions=[[1,0],[-1,0],[0,1],[0,-1]]
        rq=[]
        cq=[]
     
        for r in range(row):
            for c in range(cols):
                if grid[r][c]=="1":
                    count+=1
                    rq.append(r)
                    cq.append(c)
                    grid[r][c]="0"
                    
                    while rq:
                        cr=rq.pop(0)
                        cc=cq.pop(0)
                        
                        for d in directions:
                            nr=cr+d[0]
                            nc=cc+d[1]
                            
                            if nr>=0 and nc>=0 and nr<row and nc< cols and grid[nr][nc]=="1":
                                rq.append(nr)
                                cq.append(nc)
                                grid[nr][nc]=0
        return count