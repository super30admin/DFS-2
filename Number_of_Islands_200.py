## Problem1 (https://leetcode.com/problems/number-of-islands/)


# Time Complexity: O(m*n)  # For both BFS and DFS
# Space Complexity: O(m*n) # For DFS , O(min(m,n)) For BFS
# Solved on Leetcode?: Yes
# Code:
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        # DFS Solution
        def dfs(row,column,grid):
            # Base Condition:
            if (row < 0 or row >= m or column < 0 or column >= n or grid[row][column] != '1'):
                return
            # Logic:
            grid[row][column] = '-1'
            dfs(row+1,column,grid)
            dfs(row-1,column,grid)
            dfs(row,column+1,grid)
            dfs(row,column-1,grid)
        
        if grid == None or len(grid) == 0:
            return 0
        
        m = len(grid)
        n = len(grid[0])
        
        no_of_islands = 0

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    no_of_islands = no_of_islands + 1
                    dfs(i,j,grid)
        
        return no_of_islands
        
        #BFS solution
        #q = deque()
        #directions = [[0,1],[0,-1],[1,0],[-1,0]]
        #for i in range(m):
        #     for j in range(n):
        #         if grid[i][j] == '1':
        #             no_of_islands = no_of_islands + 1
        #             q.append([i,j])
        #             grid[i][j] = '-1'
        #             while(q):
        #                 value = q.popleft()
        #                 for dirs in directions:
        #                     nrow = value[0] + dirs[0]
        #                     ncolumn = value[1] + dirs[1]
        #                     if (nrow >= 0 and nrow < m and ncolumn >= 0 and ncolumn < n and grid[nrow][ncolumn] == '1'):
        #                         grid[nrow][ncolumn] = '-1'
        #                         q.append([nrow,ncolumn])

# Approach: In this problem, we need to find out the number of unique islands that are surrounded by water. 
#           We iterate over an entire array and find the first island represented by 1. We then check the corresponding surrounding (horizontal and vertical) of 1 and also mark that as a part of same island.
#           We stop when calculated row and column does not fall in the 2d matrix or we encounter a water. We use both DFS and BFS solution to look for islands in horizontal and vertical direction.