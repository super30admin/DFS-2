################# Iterative solution
# Time complexity: O(n)
# Space complexity: O(n)
# Worked on leetcode: yes
# Iterative approach: This algorithm a recursive dfs solutuion. We first find the 1 in the grid, and start using dfs from that grid. As soon as we traverse the neighbors
# of the cell, we keep on marking visited cells as visited by replacing all 1's with 0's. Then we repeat the process, and this way we find number of connected components
# in the grid. And the number of connected components (of 1s)corresponds to number of islands. 4



class Solution:
    def numIslands(self, grid):

        if grid == None or len(grid) == 0 or len(grid[0]) == 0: return 0

        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    count += 1
                    self.dfs(grid, i, j)

        return count

    def dfs(self, grid, i, j):
        dirs = [[-1, 0], [1, 0], [0, 1], [0, -1]]

        if i >=0 and i < len(grid) and j >=0 and j < len(grid[0]) and grid[i][j] == "1":

            grid[i][j] = "0"
            for direction in dirs:
                row = i + direction[0]
                col = j + direction[1]

                self.dfs(grid, row, col)


result = Solution()
print(result.numIslands([["1","0","1","1","0","1","1"]]))