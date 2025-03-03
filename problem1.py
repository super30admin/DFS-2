# Time Complexity : O(r*c)
# Space Complexity : O(r*c)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

class Solution:
    
    def numIslands(self, grid: List[List[str]]) -> int:
        R,C = len(grid), len(grid[0])
        visited = set()

        def inbounds(r,c):
            return 0<=r<R and 0<=c<C

        def dfs(node):
            if not node or node in visited:
                return

            visited.add(node)
            r,c = node
            for di,dj in [[0,1],[0,-1],[-1,0],[1,0]]:
                dx,dy = r+di, c+dj
                if inbounds(dx,dy) and (dx,dy) not in visited and grid[dx][dy] == "1":
                    dfs((dx,dy))

        island_count = 0
        for i in range(R):
            for j in range(C):
                if grid[i][j] == "1" and (i,j) not in visited:
                    dfs((i,j))
                    island_count += 1
        
        return island_count