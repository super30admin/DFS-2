# problem 1 : 200. Number of Islands : https://leetcode.com/problems/number-of-islands/
# Time Complexity : O(n*m) for both dfs and bfs
# Space Complexity : O(n*m) for dfs and min(m,n) in bfs
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        ## bfs
        if not grid:
            return 0
        count, rows, cols = 0, len(grid), len(grid[0])
        directions = [(1,0),(-1,0),(0,1),(0,-1)]
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == '1':
                    count += 1
                    de = collections.deque([(i,j)])
                    grid[i][j] = '0'
                    while de:
                        row, col = de.popleft()
                        for di in directions:
                            r,c = row + di[0], col + di[1]
                            if 0 <= r < rows and 0 <= c < cols and grid[r][c] == '1':
                                grid[r][c] = '0'
                                de.append((r,c))
        return count        
        ## DFS
#         if not grid:
#             return 0
#         rows, cols, count = len(grid), len(grid[0]),0
#         def dfs(r, c):
#             grid[r][c] = "0"
#             for i in range(-1, 2, 2):
#                 if (0 <= r+i< rows) and grid[r+i][c] == "1" :
#                     dfs(r+i, c)
#                 if (0 <= c+i < cols) and grid[r][c+i] == "1" :
#                     dfs(r, c+i)
        
#         for i in range(rows):
#             for j in range(cols):
#                 if (grid[i][j] == "1") :
#                     count += 1
#                     dfs(i,j)
#         return count


# problem 2 : 394. Decode String : https://leetcode.com/problems/decode-string/
# Time Complexity : O(n) 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

class Solution:
    def decodeString(self, s: str) -> str:
        if not s:
            return ""
        stack = ['']
        curr_str = ''
        curr_num = ''
        for ele in s:
            if ele.isdigit():
                curr_num += ele
            elif ele == '[':
                stack.append((curr_str, int(curr_num)))
                curr_str, curr_num = '', ''
            elif ele.isalpha():
                curr_str += ele
            elif ele == ']':
                prev_str, prev_num = stack.pop()
                curr_str = prev_str +curr_str * int(prev_num)
        return curr_str
            
                
        