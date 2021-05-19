class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        '''
        TC : O(m*n)
        SC : O(m*n)
        
        Approach : 
            traverse through the matrix
                when you found '1' at the current position 
                    apply dfs to visit the island
                do this process until we visit all the islands
            return the count of islands
            
        '''
        n = len(grid)
        if n==0: return 0
        m = len(grid[0])
        if m == 0 : return 0
        
        def dfs(q):
            while q:
                x,y = q.pop()
                d = [[0,1],[0,-1],[1,0],[-1,0]]
                for dx,dy in d:
                    if x+dx>=0 and y+dy>=0 and x+dx<n and y+dy<m and grid[x+dx][y+dy] == "1":
                        grid[x+dx][y+dy] = 0
                        q.append((x+dx,y+dy))
                        
        ans = 0
        for i in range(n):
            for j in range(m):
                if grid[i][j] == "1":
                    grid[i][j] = 0
                    dfs([(i,j)])
                    ans+=1
        return ans
        
        