# time: O(m*n) + O(m*n) = 2mn
        # consider 2 iterations:
        # - you have the outer loop
        # - and bfs - bfs in the worst case entire grid is all 1's - but you still have the outer loop
        # so it's 2mn considering visited 
        # space: O(m*n) - visit could store every node in queue
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:

        m = len(grid)
        n = len(grid[0])
        visit = set()
        def bfs(r,c):
            q = deque()
            visit.add((r,c))
            q.append((r,c))
            while q:
                row,col = q.popleft()
                directions = [(0,1),(1,0),(-1,0),(0,-1)]
                for d in directions:
                    nr = row + d[0]
                    nc = col + d[1]
                    if (nr in range(m) and nc in range(n) and grid[nr][nc]=="1" and (nr,nc) not in visit):
                        visit.add((nr,nc))
                        q.append((nr,nc))

        islands = 0
        for r in range(m):
            for c in range(n):
                # only start bfs for unvisited land
                if grid[r][c] == "1" and (r, c) not in visit:
                    bfs(r,c)
                    islands+=1

        return islands 



# DFS
# time O(m*n) - call stack could be entire grid in worse case (all 1's)
# space O(m*n)
class Solution:
    def numIslands(self, grid):
        self.dirs = [[-1,0],[1,0],[0,1],[0,-1]]
        result = 0
        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c] == '1':
                    result+=1
                    self.dfs(grid,r,c)

        return result 
    def dfs(self,grid,r,c):
        if (r < 0 or r == len(grid) or c < 0 or c == len(grid[0])) or grid[r][c]!='1':
            return

        grid[r][c]='0'
        for d in self.dirs: 
            nr = r + d[0]
            nc = c + d[1]
            self.dfs(grid,nr,nc)





