'''
In this problem we need to calculate the number of islands or number of 1's surrounded by number of 0's.
I used DFS approach, where I iterated through the matrix, recursively starting at 1's and calculating the count.
In DFS, we are going through 4 neighbors of current cell and checking if it is 1, and change it to 0, to not go through the same cell again while iterating.
'''
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        dirs = [[-1, 0], [1,0], [0,1], [0, -1]]
        m = len(grid)
        n = len(grid[0])
        count = 0
       
        # iterating through the matrix
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    # count of islands
                    count += 1
                    self.dfs(grid, i, j, m, n,dirs)
        return count

    def dfs(self, grid, i, j, m, n, dirs):
        # base: checking the baoundaries and if the value is 0
        if i < 0 or j < 0 or i == m or j == n or grid[i][j] != '1':
            return
        # logic: checking the neighbors and changing the value to 0 if it is 1.
        grid[i][j] = '0'
        for dir in dirs:
            r = dir[0] + i
            c = dir[1] + j
            self.dfs(grid, r, c, m, n, dirs)

'''
Time Complexity: O(m*n)
Time takne for iterating through the entire matrix once is m*n.
Space Complexity: O(m*n)
In worst case, space consumed by the recursive stack is m*n.
'''