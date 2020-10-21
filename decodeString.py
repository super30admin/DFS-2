// Time Complexity : O(N X M)
// Space Complexity : O(N X M)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def dfs(grid: List[List[str]], i: int, j: int) -> None:
            if i<0 or i==len(grid) or j<0 or j==len(grid[0]):
                return
            if grid[i][j] == '1':
                grid[i][j] = ''
                dfs(grid, i-1, j)
                dfs(grid, i, j-1)
                dfs(grid, i+1, j)
                dfs(grid, i, j+1)
            
        ans = 0
        if not grid or not grid[0]:
            return ans
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]=='1':
                    ans += 1
                    dfs(grid, i, j)
                    
        return ans