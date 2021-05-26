
from queue import Queue
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if(len(grid)==0 or len(grid[0])==0):
            return 0
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        count = 0
        q = Queue()
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]=="1":
                    count = count+1
                    q.put((i,j))
                    while(q.empty()!=True):
                        value = q.get()
                        for dire in dirs:
                            r = value[0]+dire[0]
                            c = value[1]+dire[1]
                            if(r>=0 and r<len(grid)) and (c>=0 and c<len(grid[0])) and (grid[r][c]=="1"):
                                grid[r][c]="0"
                                q.put((r,c))
        return count

        
