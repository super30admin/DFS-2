# Time Complexity: O(mn) or O(2mn)
# Space Complexity: O(mn) of Stack

# Approach is to start BFS at an islands. Once encountered, do a BFS to find all '1' and make them '0' and add them to the BFS as babies


from collections import deque
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        self.islands = 0
        self.m = len(grid)
        self.n = len(grid[0])
        self.q = deque()

        if grid is None or len(grid) == 0:
            return self.islands
        
        dirs = [[-1, 0], [1, 0], [0, 1], [0, -1]]
        
        for i in range(self.m):
            for j in range(self.n):
                if(grid[i][j] == '1'):
                    grid[i][j] = '0'
                    self.q.append([i, j])

                    while(len(self.q) > 0):
                        curr = self.q.pop()
                        for dir in dirs:
                            nr = dir[0] + curr[0]
                            nc = dir[1] + curr[1]

                            if (nr >= 0 and nc >= 0 and nr < self.m and nc < self.n):
                                if grid[nr][nc] == '1':
                                    grid[nr][nc] = '0'
                                    self.q.append([nr, nc])

                    self.islands += 1
                            
            
        return self.islands
        
                