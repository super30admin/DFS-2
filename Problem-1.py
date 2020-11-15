class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:

        if grid is None or len(grid)==0:
            return 0

        noi=0

        m = len(grid)
        n = len(grid[0])
        visit=set()
        def bfs(row,col):
            q=collections.deque()
            q.append((row,col))
            visit.add((row,col))

            dirs = [(1,0),(-1,0),(0,1),(0,-1)]

            while q:
                r,c = q.popleft()
                for d in dirs:
                    row = r+ d[0]
                    col = c+d[1]

                    if (row in range(m) and col in range(n) and grid[row][col]=="1" and (row,col) not in visit):
                        q.append((row,col))
                        visit.add((row,col))




        for i in range(m):
            for j in range(n):
                if grid[i][j]=='1' and (i,j) not in visit:
                    noi+=1
                    bfs(i,j)

        return noi
