#All TC on leetcode passed


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:

        #DFS approach:
        #Time complexity - O(m.n)
        #Space complexity - O(m.n)
        m = len(grid)
        n = len(grid[0])
        directions = [[1,0], [-1,0], [0,1], [0,-1]]
        count = 0

        def dfs(r,c):
            if r<0 or c<0 or r>=m or c>=n or grid[r][c]=="0":
                return
            grid[r][c]="0"
            for dr, dc in directions:
                dfs(r+dr, c+dc)

        for i in range(m):
            for j in range(n):
                if grid[i][j]=="1":
                    count+=1
                    dfs(i,j)
        return count


        #BFS approach:
        #Time complexity - O(m.n)
        #Space complexity - O(min(m,n)) - because max number of elements in the queue at any point is min(m,n)
        m = len(grid)
        n = len(grid[0])
        directions = [[1,0], [-1,0], [0,1], [0,-1]]
        count = 0
        queue = collections.deque()

        for i in range(m):
            for j in range(n):
                if grid[i][j]=="1":
                    queue.append((i,j))
                    grid[i][j]="0"
                    count+=1
                    while queue:
                        r, c = queue.popleft()
                        
                        for dr, dc in directions:
                            nr = dr+r
                            nc = dc+c
                            if nr>=0 and nc>=0 and nr<m and nc<n and grid[nr][nc]=="1":
                                grid[nr][nc]="0"
                                queue.append((nr,nc))
        return count
        