########### BFS ##############
# TC O(2*m*n) ~ O(mn)
# SC O(mn)

class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        m = len(grid)
        n = len(grid[0])
        num = 0
        q = deque()
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    num += 1
                    q.append([i,j])
                    grid[i][j] = "0"
                    while q:
                        curr = q.popleft()
                        for d in [[-1,0],[1,0],[0,-1],[0,1]]:
                            r = curr[0] + d[0]
                            c = curr[1] + d[1]
                            if r>=0 and r<m and c>=0 and c<n and grid[r][c]=="1":
                                q.append([r,c])
                                grid[r][c] = "0"
        return num        
    

########### DFS ##############
# TC O(2*m*n) ~ O(mn)
# SC O(mn)
class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """

        m = len(grid)
        n = len(grid[0])

        num = 0

        def dfs(i,j):
            if i<0 or i>=m or j<0 or j>=n or grid[i][j]!="1":
                return
            else:
                grid[i][j] = "0"
                dfs(i,j+1)
                dfs(i,j-1)
                dfs(i+1,j)
                dfs(i-1,j)


        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    num += 1
                    dfs(i,j)
                    
        return num        

