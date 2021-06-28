#BFS Solution
# // Time Complexity : O(m*n)
# // Space Complexity : O(min(m*n))
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if grid == None or len(grid) == 0: return 0
        m = len(grid)
        n = len(grid[0])
        count = 0
        q = deque()
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        for i in range(m):
            for j in range(n):

                if grid[i][j] == '1':
                    count += 1
                    q.append((i, j))
                    grid[i][j] = '0'  # mark visited
                    while q:
                        cr, cc = q.pop()
                        for d in dirs:
                            r = d[0] + cr
                            c = d[1] + cc
                            if r >= 0 and c >= 0 and r < m and c < n and grid[r][c] == '1':
                                q.append((r, c))
                                grid[r][c] = '0'
        return count

#DFS Solution
# // Time Complexity : O(m*n)
# // Space Complexity : O(m*n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count = 0
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    self.dfs(grid, i, j)
                    count += 1
        return count

    def dfs(self, grid, sr, sc):
        # base
        if sr < 0 or sc < 0 or sr == len(grid) or sc == len(grid[0]) or grid[sr][sc] == '0':
            return
        # logic
        grid[sr][sc] = '0'
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        for d in dirs:
            r = d[0] + sr
            c = d[1] + sc
            self.dfs(grid, r, c)





