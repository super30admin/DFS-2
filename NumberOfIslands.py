"""
The approach here is traverse through the array and find 1's in the array, once we find 1 we increase the
count and call the dfs function with that particular index. again in the dfs function we make the 1's as
0's so as to avoid calling dfs function on it agian and again call the dfs function on the adjacent 
index of the previously passed index. This way we find the islands one by one and finally have the count
of the islands.
Time complexity - O(N)
Space complexity - O(N)
Leetcode - Runnning
"""
def numIslands(self, grid):
        adjacent_matrix = [[0,1],[1,0],[0,-1],[-1,0]]
        count = 0
        
        def dfs(grid, i, j):
            if (0 <= i < len(grid)) and (0 <= j < len(grid[0])) and grid[i][j] == "1":
                grid[i][j] = "0"
                for x,y in adjacent_matrix:
                    newI = i + x
                    newJ = j + y
                    dfs(grid, newI, newJ) 
            return 
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    count += 1
                    dfs(grid,i,j)
        return count