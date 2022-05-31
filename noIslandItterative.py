'''
time complexity: O(m+n)
space complexity: O(m+n)
'''
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        q = deque([])
        dirs = [(1,0),(0,1),(-1,0),(0,-1)]
        lenR = len(grid)
        lenC = len(grid[0])
        count=0
        for i in range(lenR):
            for j in range(lenC):
                if(grid[i][j]=="1"):
                    count+=1
                    q.append((i,j))
                    grid[i][j]="2"
                    while(len(q)!=0):

                        curr = q.popleft()
                        grid[curr[0]][curr[1]] = "2"
                        for d1,d2 in dirs:
                            newR = d1+curr[0]   
                            newC = d2+curr[1]
                            if(newR>=0 and newC>=0 and newR<lenR and newC<lenC and grid[newR][newC]=="1"):
                                grid[newR][newC]="2"
                                q.append((newR,newC))
        return count