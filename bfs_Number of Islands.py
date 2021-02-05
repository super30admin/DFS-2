#time: O(mxn)
#space: O(min(m,n))
#leetcode: yes

#bfs

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if(grid==[]):
            return 0
        m=len(grid)
        n=len(grid[0])
        count=0
        q=deque()
        dr=[[0,1],[1,0],[-1,0],[0,-1]]
        for i in range(m):
            for j in range(n):
                if(grid[i][j]=='1'):
                    q.append([i,j])
                    count+=1
                    while(q!=deque()):
                        for s in range(len(q)):
                            row,column=q.popleft()
                            for d in dr:
                                r=d[0]+row
                                c=d[1]+column
                                if(r>=0 and r<m and c>=0 and c<n and grid[r][c]=='1'):
                                    grid[r][c]='0'
                                    q.append([r,c])
        return count