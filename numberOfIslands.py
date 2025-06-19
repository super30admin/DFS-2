# TC: O(mn)
# SC: O(mn)

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m=len(grid)
        n=len(grid[0])
        count=0

        def helper(i,j):
            dirs=[(0,1), (1,0), (0,-1), (-1,0)]
            q=deque([])
            q.append((i,j))
            while q:
                cr,cc=q.popleft()

                for dr,dc in dirs:
                    nr=cr+dr
                    nc=cc+dc

                    if nr>=0 and nc>=0 and nr<m and nc<n and grid[nr][nc]=='1':
                        q.append((nr,nc))
                        grid[nr][nc]='-1'


        for i in range(m):
            for j in range(n):
                if grid[i][j]=='1':
                    helper(i,j)
                    count+=1
        
        return count

