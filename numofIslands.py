"""
Linear scan the 2D grid map, if a node contains a '1', then it is a root node that triggers a Depth First Search.
During DFS, every visited node should be set as '0' to mark as visited node. Count the number of root nodes
that trigger DFS, this number would be the number of islands since each DFS starting at some root identifies
an island.
python soln - https://leetcode.com/problems/number-of-islands/discuss/56340/Python-Simple-DFS-Solution

Iterate through each of the cell and if it is an island, do dfs to mark all adjacent islands,
then increase the counter by 1.
tc - o(MXN)
SC - o(mxn)

bfs -
tc - o(mxn)
sc - min betwen m and n
"""


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count = 0
        if not grid:
            return 0

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    self.dfs(grid, i, j)
                    count += 1
        return count

    def dfs(self, grid, i, j):
        if i < 0 or j < 0 or j >= len(grid[0]) or i >= len(grid) or grid[i][j] != '1':
            return

        grid[i][j] = '#'
        self.dfs(grid, i + 1, j)
        self.dfs(grid, i - 1, j)
        self.dfs(grid, i, j + 1)
        self.dfs(grid, i, j - 1)
