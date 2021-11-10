# 200. Number of Islands
# https://leetcode.com/problems/number-of-islands/

# Logic: Iterate the matrix. When you find a 1, start BFS and increment the island count.

# Time Complexiety: O(n*m)
# Space Complexiety: O(min(n,m))

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        n = len(grid)
        m = len(grid[0])
        islandCount = 0
        q = list()
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        
        for i in range(n):
            for j in range(m):
                if grid[i][j] == '1':
                    q.append((i,j))
                    grid[i][j] = '2'
                    islandCount += 1
                    
                    while q:
                        row, col = q.pop(0)
                        
                        for _dir in dirs:
                            newRow = row + _dir[0]
                            newCol = col + _dir[1]
                            
                            if 0 <= newRow < n and 0 <= newCol < m:
                                if grid[newRow][newCol] == "1":
                                    q.append((newRow,newCol))
                                    grid[newRow][newCol] = "2"
        return islandCount