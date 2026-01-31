## Problem1 (https://leetcode.com/problems/number-of-islands/)
## Time complexity: O(M*N)
## Space Complexity: O(M*N)

class Solution(object):
    def numIslands(self, grid):

        # Number of rows and columns in the grid
        ROWS = len(grid)
        COLS = len(grid[0])

        def dfs(r, c):
            ## Depth-First Search to visit all connected land cells starting from position (r, c).
            # Base case:
            # - out of bounds
            # - water cell
            # - already visited
            if (r < 0 or r >= ROWS or
                c < 0 or c >= COLS or
                grid[r][c] == '0' or
                (r, c) in visited):
                return
            
            # Mark the current cell as visited
            visited.add((r, c))
            
            # Explore all 4 possible directions
            for dr, dc in [(0,1), (1,0), (-1,0), (0,-1)]:
                nr, nc = r + dr, c + dc
                dfs(nr, nc)

        # Set to keep track of visited land cells
        visited = set()

        # Counter for number of islands
        count = 0

        # Traverse every cell in the grid
        for r in range(ROWS):
            for c in range(COLS):
                # If the cell is land and not yet visited,
                # it represents a new island
                if (r, c) not in visited and grid[r][c] == '1':
                    dfs(r, c)     # Visit the entire island
                    count += 1    # Increment island count

        # Return the total number of islands
        return count



## Problem2 (https://leetcode.com/problems/decode-string/)
## Time complexity: O(N)
## Space Complexity: O(N)

class Solution(object):
    
    def decodeString(self, s):
        

        stack = []   # Stack to store characters and intermediate decoded strings
        res = ''     # (Not strictly needed here, but kept as in original code)
        
        # Traverse each character in the input string
        for c in s:
            
            # If the current character is not a closing bracket,
            # simply push it onto the stack
            if c != ']':
                stack.append(c)
                
            else:
                # When we encounter ']', start decoding the substring

                tmp = ''  # To store the encoded string inside brackets
                
                # Pop characters until '[' is found
                while stack and stack[-1] != '[':
                    tmp = stack.pop() + tmp   # Build substring in correct order
                
                # Remove the '[' from stack
                stack.pop()
                
                num = ''  # To store the repeat count (may be multi-digit)
                
                # Pop all digit characters to form the number k
                while stack and stack[-1].isdigit():    
                    num = stack.pop() + num
                
                # Repeat the decoded substring k times
                # and push it back onto the stack
                stack.append(int(num) * tmp)
        
        # Join everything left in the stack to form the final decoded string
        return "".join(stack)
