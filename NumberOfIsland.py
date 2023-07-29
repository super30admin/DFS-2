from ast import List

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        row = len(grid)
        col = len(grid[0])
        visited = set()
        count = 0
        for r in range(row):
            for c in range(col):
                if self.explore(r, c, grid, visited):
                    count += 1
        return count
                
    
    def explore(self,r, c, graph, visited):
        rowBound = 0 <= r < len(graph)
        colBound = 0 <= c < len(graph[0])
        if not rowBound or not colBound:
            return False   
        if (r, c) in visited:
            return False
        visited.add((r, c))

        if graph[r][c] != "1":
            return False

        self.explore(r+1, c, graph, visited)
        self.explore(r, c+1, graph, visited)
        self.explore(r-1, c, graph, visited)
        self.explore(r, c-1, graph, visited)
        
        return True