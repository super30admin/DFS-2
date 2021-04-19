"""
Approach - BFS
TC - O(m*n)
SC - O(m*n)
"""

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if (not grid or len(grid) == 0):
            return 0
    
        rows = len(grid)
        columns = len(grid[0])
        count = 0

        queue = []

        for r in range(rows):
            for c in range(columns):
                if grid[r][c] == '1':
                    count += 1
        
                    grid[r][c] = '0'
                    queue.append([r, c])
                    while queue:
                        
                        current = queue.pop(0)
                
                        directions = [[0,1], [0,-1], [1,0], [-1,0]]
                        
                        for direct in directions:
                            dr = current[0] + direct[0]
                            dc = current[1] + direct[1]
                            #print("RC vals : ", dr,dc , "Val: ", grid[dr][dc])
                            if (dr >= 0 and dr < rows and dc >= 0 and dc < columns and grid[dr][dc] == "1"):
                                #print("making 0 at ", dr,dc)
                                grid[dr][dc] = '0'
                                #print(grid)
                                queue.append([dr,dc])
                                
        return count



