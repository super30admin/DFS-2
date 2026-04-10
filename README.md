# DFS-2

## Problem1 (https://leetcode.com/problems/number-of-islands/)

Time Complexity = O(mxn)
Space = min(m,n)

BFS

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0

        rows, cols = len(grid), len(grid[0])
        islands = 0
        visited = set()

        def bfs(r, c):
            q = collections.deque()
            q.append((r, c))
            visited.add((r,c))

            while q:
                row, col = q.popleft()
                directions = ((-1, 0), (1, 0), (0, -1), (0, 1))
                for dr, dc in directions:
                    r = row + dr
                    c = col + dc
                    if (
                        (r in range(rows) and c in range(cols))
                        and ((r, c) not in visited)
                        and ((r, c) not in q)
                        and (grid[r][c] == "1")
                    ):
                        q.append((r, c))
                        visited.add((r,c))

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == "1" and (r, c) not in visited:
                    bfs(r, c)
                    islands += 1

        return islands


DFS

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0

        rows, cols = len(grid), len(grid[0])
        islands = 0

        def dfs(r, c):
            if (r < 0 or c < 0 or r == len(grid) or c == len(grid[0]) or grid[r][c] != "1"):
                return

            # logic
            grid[r][c] = "0"
            directions = ((-1, 0), (1, 0), (0, -1), (0, 1))
            for dir in directions:
                rw = r + dir[0]
                cl = c + dir[1]
                dfs(rw, cl)
                
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == "1":
                    islands += 1
                    dfs(r, c)
        return islands
    



## Problem2 (https://leetcode.com/problems/decode-string/)

Time = O(S), where S = decoded output length
Space = O(k), k is length of the result and k >= n

class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        for i in range(len(s)):
            if s[i] != ']':
                stack.append(s[i])
            else:
                substr = ''
                while stack[-1] != '[':
                    substr = stack.pop() + substr
                stack.pop()
                k = ''
                while stack and stack[-1].isdigit():
                    k = stack.pop() + k
                
                stack.append(int(k) * substr)
        
        return ''.join(stack)
                

