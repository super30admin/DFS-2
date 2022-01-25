# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution(object):
    count = 0
    def numIslands(self, grid):
        m = len(grid)
        n = len(grid[0])
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        #BFS
        q = deque()
        dirs = [[1,0],[-1,0],[0,1],[0,-1]]
        if not grid: return 0
        for i in range (m):
            for j in range (n):
                if grid[i][j] == "1":
                    self.count += 1
                    q.append([i,j])
                    while q:
                        curr = q.popleft()
                        for dir in dirs:
                            r = curr[0] + dir[0]
                            c = curr[1] + dir[1]
                            if r >= 0 and r < m and c >= 0 and c < n and grid[r][c] == "1":
                                q.append([r,c])
                                grid[r][c] = "0"
        return self.count
        
        #DFS
        # if not grid: return 0
        # def dfs(i,j):
        #     # Base
        #     if i < 0 or i == m or j < 0 or j == n or grid[i][j] == "0":
        #         return 0
        #     # Logic
        #     grid[i][j] = "0"
        #     dfs(i,j+1)
        #     dfs(i,j-1)
        #     dfs(i+1,j)
        #     dfs(i-1,j)
        # for i in range (m):
        #     for j in range (n):
        #         if grid[i][j] == "1":
        #             self.count += 1
        #             dfs(i,j)
        # return self.count
