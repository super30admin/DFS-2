# Time complexity: O(m *n)
# Space complexity: O(m *n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# DFS Approach
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        self.m = len(grid)
        self.n = len(grid[0])
        # count the islands
        count = 0
        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == "1":
                    count += 1
                    self.dfs(grid , i , j)
        return count
    
    def dfs(self, grid, i, j):
        #base
        if (i<0 or j< 0 or i == self.m or j == self.n or grid[i][j] != '1'):
            return # return dfs function only
        # logic
        grid[i][j] = '0' 
        directions = [(-1, 0), (1,0), (0,1), (0, -1)]
        for dir in directions:
            r = dir[0] + i
            c = dir[1] + j
            self.dfs(grid, r, c)
            
            
            
#BFS Approach
# Time complexity: O(m*n)
# Space complexity: O(m *n)

class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        # BFS Approach
        m = len(grid)
        n = len(grid[0])
        queue = deque()
        # Predefine directions
        directions = [(-1, 0), (1,0), (0,1), (0, -1)]
        # count the islands
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    count += 1
                    # first initial value if we found as land
                    queue.append((i,j))
                    grid[i][j] == "0"
                    # check for rest direction and add to queue and make the grid as 0
                    while queue:
                        curr = queue.popleft()
                        for dir in directions:
                            r =  dir[0] + curr[0] 
                            c =  dir[1] + curr[1]
                            if r >= 0 and c >= 0 and r < m and c < n and grid[r][c] == "1":
                                # check the direction which we mentioned in 4 ways and make it 0
                                queue.append((r, c))
                                grid[r][c] = "0"
                                
        # return the count 
        return count
