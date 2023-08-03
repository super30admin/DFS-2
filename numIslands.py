#TC - O(M*N)
#SC - O(M*N)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        ROWS = len(grid)
        COLS = len(grid[0])
        visit = set()
        def bfs(r,c):
            q=collections.deque()
            q.append((r,c))
            visit.add((r,c))
            while q:
                row, col = q.popleft()
                directions = [[0,1],[1,0],[-1,0],[0,-1]]
                for dr,dc in directions:
                    rc,cc = row+dr,col+dc
                    if (rc>=0 and cc>=0 and rc<ROWS and cc<COLS and grid[rc][cc]!="0" and (rc,cc) not in visit):
                        q.append((rc,cc))
                        visit.add((rc,cc))
        res=0
        for i in range(ROWS):
            for j in range(COLS):
                if grid[i][j]=="1" and (i,j) not in visit:
                        bfs(i,j)
                        res+=1
        return res
