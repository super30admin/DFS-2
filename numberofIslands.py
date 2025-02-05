# Time Complexity : O(m*n)
# Space Complexity : O(m+n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : none
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid is None or len(grid) == 0:
            return 0
        
        m = len(grid)
        n = len(grid[0])
        dirs = [[-1,0], [1,0], [0,-1], [0,1]] #U D L R
        count = 0

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    count += 1
                    q = deque()
                    grid[i][j] = '2'
                    q.append((i,j))
                    while q:
                        r, c = q.popleft()
                        for dr, dc in dirs:
                            nr = r + dr
                            nc = c + dc
                            if nr >= 0 and nr < m and nc >= 0 and nc < n and grid[nr][nc] == '1':
                                q.append((nr,nc))
                                grid[nr][nc] = '2'

        return count