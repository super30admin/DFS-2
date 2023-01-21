# Time Complexity :O(m*n)
# Space Complexity :O(m*n)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No

class Solution(object):
    def numIslands(self, grid):
        count=0
        dire=[[0,1],[1,0],[-1,0],[0,-1]]
        q=deque()
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if(grid[i][j]=='1'):
                    q.append((i,j))
                    grid[i][j]=0
                    count+=1
                    while(q):
                        t=q.popleft()
                        a,b=t[0],t[1]
                        
                        for l in dire:
                            nr=a+l[0]
                            nc=b+l[1]
                            if(nr>=0 and nr<len(grid) and nc>=0 and nc<len(grid[0]) and grid[nr][nc]=='1'):
                                q.append((nr,nc))
                                grid[nr][nc]=0
        return (count)
