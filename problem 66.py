# Problem1 (https://leetcode.com/problems/number-of-islands/)


# Time Complexity : O(m * n)
# Space Complexity : O(m * n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])

        if not grid:
            return 0
        count = 0

        dirs = [[-1,0],[1,0],[0,-1],[0,1]]

        for i in range (m):
            for j in range(n):
                if grid[i][j] == '1':
                    count +=1
                    q = deque()
                    q.append([i,j])
                    
                    while q:
                        curr = q.popleft()        
                        for d in dirs:
                            nr = d[0] + curr[0]
                            nc = d[1] + curr[1]
                            if nr >= 0 and nr<m and nc >= 0 and nc < n and grid[nr][nc] == '1' :
                                q.append([nr,nc])
                                grid[nr][nc] = '0'
        
        return count


# DFS

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])

        if not grid:
            return 0
        count = 0

        dirs = [[-1,0],[1,0],[0,-1],[0,1]]

        for i in range (m):
            for j in range(n):
                if grid[i][j] == '1':
                    count +=1
                    self.dfs(grid,i,j,dirs,m,n)
            
        return count

    def dfs(self,grid,r,c,dirs,m,n):
        # base
        if r < 0 or r == m or c < 0 or c == n or grid[r][c] != '1' :
            return

        # logic
        grid[r][c] = '0'
        for d in dirs:
            nr = d[0] + r
            nc = d[1] + c
            self.dfs(grid,nr,nc,dirs,m,n)
                           