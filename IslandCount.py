# Time Complexity : O(numRows * numCols)
# Space Complexity : O( min(numRows, numCols) )  # https://imgur.com/gallery/M58OKvB (Reference)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach

from collections import deque
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        def bfs(i, j):
            q = deque([])
            q.append((i, j))
            grid[i][j] = "-1"
            
            while q:
                row, col = q.popleft()
                for d in dirs:
                    adjRow, adjCol = row + d[0], col + d[1]
                    if 0 <= adjRow < numRows and 0 <= adjCol < numCols:
                        if grid[adjRow][adjCol] == '1':
                            q.append((adjRow, adjCol))
                            grid[adjRow][adjCol] = '-1'
            
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        numRows = len(grid)
        numCols = len(grid[0])
        count = 0
        for i in range(numRows):
            for j in range(numCols):
                if grid[i][j] == '1':
                    count += 1
                    bfs(i,j)
                    
        return count