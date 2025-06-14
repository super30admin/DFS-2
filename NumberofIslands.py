# Space Complexity - o(min(m,n))
# Time Complexity - o(m*n)

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        directions = [[0,1],[1,0],[0,-1],[-1,0]]
        q = deque()
        m = len(grid)
        n = len(grid[0])
        cnt = 0

        for i in range(m):
            for j in range(n):
                if grid[i][j]=='1':
                    grid[i][j]='0'
                    q.append([i,j])
                    while q:
                        r, c = q.popleft()

                        for dr, dc in directions:
                            row = r+dr
                            col = c+dc

                            if 0<=row<m and 0<=col<n and grid[row][col]=='1':
                                grid[row][col]='0'
                                q.append([row,col])

                    cnt+=1

        return cnt

        
        