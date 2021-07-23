#Time: O(n) Visit all elements once
#Space: O(n) Recursion stack
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        
        def traverse(r,c,grid):
            grid[r][c] = 0
            # visited.add((r,c))
            for r_shift,c_shift in [(-1,0),(1,0),(0,-1),(0,1)]:
                if r+r_shift>=0 and r+r_shift<len(grid) and c+c_shift>=0 and c+c_shift<len(grid[0]) and (r+r_shift,c+c_shift) and grid[r+r_shift][c+c_shift] == "1":
                    traverse(r+r_shift,c+c_shift,grid)
        
        ans = 0
        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if (grid[r][c]) == "1" and (r,c):
                    traverse(r,c,grid)
                    ans+=1
                    # print(grid)
        return ans