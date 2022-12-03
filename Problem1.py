#Time complexity: O(m*n)
#Space complexity: O(m*n)

#Accepted on leetcode

#Approach
#Use a recursive approach (can be called DFS) where you DFS through a starting one and process all neighbouring ones
#Mark all processed ones (for a given DFS call), so they are not repeated
#Total number of top-level DFS calls is equal to the total number of islands

from collections import deque

class Solution:
    dirs = [[-1,0],[1,0], [0,-1], [0,1]] #U D L R
    def numIslands(self, grid: List[List[str]]) -> int:
        islandCount = 0
        queue = deque()
        n = len(grid)
        m = len(grid[0])

        #Traverse, for each unprocessed land node i.e 1, execute bfs and mark all of it's connected land nodes processed
        for i in range(n):
            for j in range(m):
                if grid[i][j] == "1": #unprocessed
                    grid[i][j] = -1 #process it
                    queue.append([i,j])
                    self.bfs(queue, grid)
                    islandCount += 1

        return islandCount

    def bfs(self,queue, grid):
        n = len(grid)
        m = len(grid[0])
        while len(queue):
            curNodeIndices = queue.popleft()
            r = curNodeIndices[0]
            c = curNodeIndices[1]
            #check all 4 directions for land
            for dirn in self.dirs:
                nr = r + dirn[0]
                nc = c + dirn[1]
                if nr >= 0 and nr < n and nc >= 0 and nc < m and grid[nr][nc] == "1": #unprocessed node found
                    grid[nr][nc] = -1
                    queue.append([nr,nc])
        


