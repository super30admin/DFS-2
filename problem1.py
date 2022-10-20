class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        dirs=[[-1,0],[0,-1],[1,0],[0,1]]
        m = len(grid)
        n=len(grid[0])
        count=0
        for i in range(m):
            for j in range(n):
                if grid[i][j]=='1':
                    count+=1
                    q=[]
                    q.append([i,j])
                    while q:
                        curr=q.pop(0)
                        for d in dirs:
                            nr=curr[0]+d[0]
                            nc=curr[1]+d[1]
                            if nr>=0 and nr <m and nc>=0 and nc<n and grid[nr][nc]=='1':
                                grid[nr][nc]='0'
                                q.append([nr,nc])
        return count