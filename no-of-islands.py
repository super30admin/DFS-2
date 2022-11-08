# TC: (m x n)
# SC: O(m x n)

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        rows,cols=len(grid),len(grid[0])
        
        island=0
        visited=set()
        
        def bfs(r,c):
            q=collections.deque()
            directons=[(0,1),(0,-1),(1,0),(-1,0)]
            
            q.append((r,c))
            
            while q:
                
                row,col=q.popleft()
                for dr,dc in directons:
                    r,c=row+dr,col+dc
                    if r in range(rows) and c in range(cols) and grid[r][c]=="1" and (r,c) not in visited:
                        visited.add((r,c))
                        q.append((r,c))
            
        for r in range(rows):
            for c in range(cols):
                if grid[r][c]=="1" and (r,c) not in visited:
                    island+=1
                    bfs(r,c)
                    
                    
        return island
        
        